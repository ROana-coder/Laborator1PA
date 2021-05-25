package movies.spring.data.neo4j.service;

import movies.spring.data.neo4j.MovieDto.CastMember;
import movies.spring.data.neo4j.MovieDto.Details;
import movies.spring.data.neo4j.MovieDto.Result;
import movies.spring.data.neo4j.movieEntity.Movie;
import movies.spring.data.neo4j.repository.MovieRepository;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Value;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	private final Neo4jClient neo4jClient;

	private final Driver driver;

	private final DatabaseSelectionProvider databaseSelectionProvider;

	MovieService(MovieRepository movieRepository,
				 Neo4jClient neo4jClient,
				 Driver driver,
				 DatabaseSelectionProvider databaseSelectionProvider) {

		this.movieRepository = movieRepository;
		this.neo4jClient = neo4jClient;
		this.driver = driver;
		this.databaseSelectionProvider = databaseSelectionProvider;
	}

	public Details fetchDetailsByTitle(String title) {
		return this.neo4jClient
				.query("" +
						"MATCH (movie:Movie {title: $title}) " +
						"OPTIONAL MATCH (person:Person)-[r]->(movie) " +
						"WITH movie, COLLECT({ name: person.name, job: REPLACE(TOLOWER(TYPE(r)), '_in', ''), role: HEAD(r.roles) }) as cast " +
						"RETURN movie { .title, cast: cast }"
				)
				.in(database())
				.bindAll(Map.of("title", title))
				.fetchAs(Details.class)
				.mappedBy(this::toMovieDetails)
				.one()
				.orElse(null);
	}

	public List<Result> searchMoviesByTitle(String title) {
		return this.movieRepository.findByTitle(title)
				.stream()
				.map(Result::new)
				.collect(Collectors.toList());
	}

	public List<Result> searchMoviesByYear(Integer an) {
		return this.movieRepository.findByYear(an)
				.stream()
				.map(Result::new)
				.collect(Collectors.toList());
	}

	public Map<String, List<Object>> fetchMovieGraph() {

		var nodes = new ArrayList<>();
		var links = new ArrayList<>();

		try (Session session = sessionFor(database())) {
			var records = session.readTransaction(tx -> tx.run(""
				+ " MATCH (m:Movie) <- [r:ACTED_IN] - (p:Person)"
				+ " WITH m, p ORDER BY m.title, p.name"
				+ " RETURN m.title AS movie, collect(p.name) AS actors"
			).list());
			records.forEach(record -> {
				var movie = Map.of("label", "movie", "title", record.get("movie").asString());

				var targetIndex = nodes.size();
				nodes.add(movie);

				record.get("actors").asList(Value::asString).forEach(name -> {
					var actor = Map.of("label", "actor", "title", name);

					int sourceIndex;
					if (nodes.contains(actor)) {
						sourceIndex = nodes.indexOf(actor);
					} else {
						nodes.add(actor);
						sourceIndex = nodes.size() - 1;
					}
					links.add(Map.of("source", sourceIndex, "target", targetIndex));
				});
			});
		}
		return Map.of("nodes", nodes, "links", links);
	}

	private Session sessionFor(String database) {
		if (database == null) {
			return driver.session();
		}
		return driver.session(SessionConfig.forDatabase(database));
	}

	private String database() {
		return databaseSelectionProvider.getDatabaseSelection().getValue();
	}

	private Details toMovieDetails(TypeSystem ignored, org.neo4j.driver.Record record) {
		var movie = record.get("movie");
		return new Details(
				movie.get("title").asString(),
				movie.get("cast").asList((member) -> {
					var result = new CastMember(
							member.get("name").asString(),
							member.get("job").asString()
					);
					var role = member.get("role");
					if (role.isNull()) {
						return result;
					}
					return result.withRole(role.asString());
				})
		);
	}

	public String save(Movie newMovie) {

//		CREATE (The:Movie {title:'blabla', released:1999, tagline:'blablabla'})
//		CREATE (Sasuke:Person {name:'Sasuke Uchiha', born:1964})
//		CREATE
//				(Sasuke)-[:ACTED_IN {roles:['Shadow']}]->(The)

		try (Session session = driver.session()) {
			 session.run("CREATE (movie:Movie " +
					"{title : '" + newMovie.getTitle() + "'," +
					" released : " + newMovie.getReleased() + "," +
					" tagline : '" + newMovie.getTagline() + "'})\n" +
					"WITH movie\n" +
					"MATCH (Oana:Person) WHERE Oana.name = 'Rotaru Oana'" +
					"CREATE (Oana)-[:RECOMMEDED]->(movie)"
					 );

			 return "Added succesfully! Go back to search page!";
		}
		//return movieRepository.save(newMovie);
	}

	public String recommend(String title)
	{
		try (Session session = driver.session()) {
			session.run("MATCH (movie:Movie) WHERE movie.title = " +
					"'" + title + "'" +
					"MATCH (Oana:Person) WHERE Oana.name = 'Rotaru Oana'" +
					"CREATE (Oana)-[:RECOMMEDED]->(movie)"
			);

			return "You recommended a movie! Go back to search page!";
		}
	}


	public Mono<Movie> findOneByTitle(String title) {
		return movieRepository.findOneByTitle(title);
	}


}
