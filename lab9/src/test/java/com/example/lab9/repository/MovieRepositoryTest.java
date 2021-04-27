package com.example.lab9.repository;

import com.example.lab9.entity.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    @Test
    void createMovie() {
        //arrange
        Movie movie = new Movie("Sisif", 2020, 2, 7);
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.createMovie("Sisif", 2020, 2, 7);
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movie);
        //act
        String result = movieRepository.findByTitle("Sisif").toString();
        //assert
        assertEquals(expectedResult.toString(),result);
    }

    @Test
    void findByTitle() {
        //arrange
        MovieRepository movieRepository = new MovieRepository();
        Movie movie = new Movie(41, "Purge", 1999, 2, 8);
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movie);
        //act
        String result = movieRepository.findByTitle("Purge").toString();
        //assert
        assertEquals(expectedResult.toString(),result);
    }

    @Test
    void findById() {
        MovieRepository movieRepository = new MovieRepository();
        Movie movie = new Movie(41, "Purge", 1999, 2, 8);
        List<Movie> expectedResult = new ArrayList<>();
        expectedResult.add(movie);
        String result = movieRepository.findById(41).toString();
        assertEquals(expectedResult.toString(),result);
    }
}