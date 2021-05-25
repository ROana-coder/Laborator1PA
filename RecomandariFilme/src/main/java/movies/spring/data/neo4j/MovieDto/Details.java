package movies.spring.data.neo4j.MovieDto;

import java.util.List;
import java.util.Objects;

public class Details {

    private final String title;

    private final List<CastMember> cast;

    public Details(String title, List<CastMember> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public List<CastMember> getCast() {
        return cast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details that = (Details) o;
        return Objects.equals(title, that.title) && Objects.equals(cast, that.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cast);
    }
}
