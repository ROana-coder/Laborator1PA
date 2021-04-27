package com.example.lab9;




import com.example.lab9.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MovieDAO extends DataAccessObject<Movie> {

    private static final String insert = "INSERT INTO movies (id, title, release_date, duration, score)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String getById = "SELECT title from movies WHERE id = ?";
    private static final String getOne = "SELECT id, title, release_date, duration, score from movies where id = ?";
    private static final String update = "UPDATE movies SET title = ?, " +
            "release_date = ?," +
            "duration = ?," +
            "score = ? WHERE id = ?";
    private static final String delete = "DELETE FROM movies where id = ?";

    public MovieDAO(Connection connection) {
        super(connection);
    }


    @Override
    public Movie findById(int id) {

        Movie movie = new Movie();
        try (PreparedStatement statement = this.connection.prepareStatement(getOne);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setReleaseDate(resultSet.getInt("release_date"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setScore(resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return movie;
    }

    @Override
    public Movie create(Movie dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(insert)) {
            statement.setInt(1, dto.getId());
            statement.setString(2, dto.getTitle());
            statement.setInt(3, dto.getReleaseDate());
            statement.setInt(4, dto.getDuration());
            statement.setInt(5, dto.getScore());
            statement.execute();
            int id = this.getLastValue(movieSequence);
            return this.findById(dto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public Movie update(Movie dto) {
        Movie movie = null;
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try (PreparedStatement statement = this.connection.prepareStatement(update);) {

            statement.setInt(1, dto.getId());
            statement.setString(2, dto.getTitle());
            statement.setInt(3, dto.getReleaseDate());
            statement.setInt(4, dto.getDuration());
            statement.setInt(5, dto.getScore());
            statement.execute();
            /* COMMIT */
            this.connection.commit();
            movie = this.findById(dto.getId());
            return movie;
        } catch (SQLException e) {
            try {
                /* ROLLBACK */
                this.connection.rollback();
            } catch (SQLException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Movie movie = null;
        try (PreparedStatement statement = this.connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findByName(String dto) {
        return null;
    }

}

