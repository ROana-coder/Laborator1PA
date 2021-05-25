package movies.spring.data.neo4j.movieEntity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node("Movie")
public class Movie {

	@Id
	@Property("title")
	private final String title;
	@Property("tagline")
	private final String tagline;
	@Property("released")
	private Integer released;
//	@Property("genre")

	@Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
	private Set<Person> actors = new HashSet<>();
	@Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
	private Set<Person> directors = new HashSet<>();
	public Movie(String title, String tagline, Integer released) {
		this.title = title;
		this.tagline = tagline;
		this.released = released;
	}

	public String getTitle() {
		return title;
	}

	public String getTagline() {
		return tagline;
	}

	public Integer getReleased() {
		return released;
	}

	public void setReleased(Integer released) {
		this.released = released;
	}
}
