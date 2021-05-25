package movies.spring.data.neo4j.MovieDto;

import movies.spring.data.neo4j.movieEntity.Movie;

import java.util.Objects;

public class Result {

    private final Movie movie;

    public Result(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie);
    }
}
