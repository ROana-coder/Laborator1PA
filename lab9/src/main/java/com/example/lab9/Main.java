package com.example.lab9;


import com.example.lab9.entity.Movie;
import com.example.lab9.repository.MovieRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class Main {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        MovieRepository movieRepository = new MovieRepository();
//        Movie movie = new Movie();
//        movie.setTitle("Mamma");
//        movie.setId(22);
//        movie.setDuration(3);
//        movie.setReleaseDate(2003);
//        movie.setScore(8);

        Chart chart = new Chart();
        List<Movie> movies = movieRepository.findById(50);
        for (Movie movie1: movies) {
            chart.add(movie1);
        }
        movies = movieRepository.findById(51);
        for (Movie movie1: movies) {
            chart.add(movie1);
        }
        movies = movieRepository.findById(52);
        for (Movie movie1: movies) {
            chart.add(movie1);
        }
        movies = movieRepository.findById(53);
        for (Movie movie1: movies) {
            chart.add(movie1);
        }
        movies = movieRepository.findById(41);
        for (Movie movie1: movies) {
            chart.add(movie1);
        }
        chart.printChart();
        chart.sort();
        //movieRepository.createMovie("Grinch", 2, 2000, 10);

//         System.out.println(movieRepository.findByTitle("Purge"));
//        System.out.println(movieRepository.findById(37));

        try {
            /* Establishing the connection */
            Connection connection = connectionManager.getConnection();

            /* PERFORMING CRUD OPERATIONS */

            MovieDAO movieDAO = new MovieDAO(connection);

           // Movie movie = new Movie();
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
            //movie = movieDAO.findById(37);
//            System.out.println(movie.toString());
//
//            movie.setReleaseDate(2001);
//            movie.setScore(10);
//            System.out.println(movie.toString());
//            movie = movieDAO.update(movie);
//            System.out.println(movie.toString());

            movieDAO.delete(38);
            connection.close();

//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//            EntityManager em = emf.createEntityManager();
//            //em.getTransaction().begin();
//            em.close();
//            emf.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
