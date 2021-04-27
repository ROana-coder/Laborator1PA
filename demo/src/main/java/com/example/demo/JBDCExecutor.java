package com.example.demo;

import com.example.demo.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;

class JDBCExecutor {

    public static void main(String[] args) throws SQLException {
        //DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        MovieRepository movieRepository = new MovieRepository();
        MovieMoviesEntity movie = new MovieMoviesEntity();
        movie.setTitle("Mamma");
        movie.setId(22);
        movie.setDuration(3);
        movie.setReleaseDate(2003);
        movie.setScore(8);
        //movieRepository.createMovie(movie);
        // System.out.println(movieRepository.findByTitle("Purge"));
//        System.out.println(movieRepository.findById(37));

//        try {
//            /* Establishing the connection */
//            Connection connection = connectionManager.getConnection();
//
//            /* PERFORMING CRUD OPERATIONS */
//
//            MovieDAO movieDAO = new MovieDAO(connection);
//
//            Movie movie = new Movie();
////            movie.setId(40);
////            movie.setTitle("Insidious");
////            movie.setReleaseDate(1989);
////            movie.setDuration(1);
////            movie.setScore(7);
////            movie.setId(41);
////            movie.setTitle("Purge");
////            movie.setReleaseDate(1999);
////            movie.setDuration(2);
////            movie.setScore(8);
////            movie = movieDAO.create(movie);
////            System.out.println(movie);
////
//            movie = movieDAO.findById(37);
//            System.out.println(movie.toString());
//
//            movie.setReleaseDate(2001);
//            movie.setScore(10);
//            System.out.println(movie.toString());
//            movie = movieDAO.update(movie);
//            System.out.println(movie.toString());
//
//            movieDAO.delete(38);
//            connection.close();
//
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//            EntityManager em = emf.createEntityManager();
//            //em.getTransaction().begin();
//            em.close();
//            emf.close();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
