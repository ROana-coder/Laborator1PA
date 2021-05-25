package movies.spring.data.neo4j.repository;

import movies.spring.data.neo4j.movieEntity.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface MovieRepository extends Repository<Movie, String> {

	@Query("MATCH (movie:Movie) WHERE movie.title CONTAINS $title RETURN movie")
	List<Movie> findByTitle(@Param("title") String title);

	@Query("MATCH (movie:Movie) WHERE movie.title =  $title RETURN movie")
	Mono<Movie> findOneByTitle(@Param("title")String title);

	@Query("CREATE (movie:Movie {title: $newMovie.title, released: $newMovie.released, tagline : $newMovie.tagline})")
	Mono<Movie> save(@Param("newMovie")Movie newMovie);

	@Query("MATCH (movie:Movie) WHERE movie.released = toInteger($an) RETURN movie")
	List<Movie> findByYear(@Param("an") Integer an);
}
