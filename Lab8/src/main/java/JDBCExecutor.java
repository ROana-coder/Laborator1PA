import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        try {
            /* Establishing the connection */
            Connection connection = connectionManager.getConnection();

            /* PERFORMING CRUD OPERATIONS */

            MovieDAO movieDAO = new MovieDAO(connection);

            Movie movie = new Movie();
//            movie.setId(40);
//            movie.setTitle("Insidious");
//            movie.setReleaseDate(1989);
//            movie.setDuration(1);
//            movie.setScore(7);
//            movie.setId(41);
//            movie.setTitle("Purge");
//            movie.setReleaseDate(1999);
//            movie.setDuration(2);
//            movie.setScore(8);
//            movie = movieDAO.create(movie);
//            System.out.println(movie);
//
            movie = movieDAO.findById(37);
            System.out.println(movie.toString());

            movie.setReleaseDate(2001);
            movie.setScore(10);
            System.out.println(movie.toString());
            movie = movieDAO.update(movie);
            System.out.println(movie.toString());

            //movieDAO.delete(38);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
