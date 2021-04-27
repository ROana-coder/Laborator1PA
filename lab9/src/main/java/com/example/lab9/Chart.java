package com.example.lab9;

import com.example.lab9.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Chart {
    private List<Movie> movies = new ArrayList<>();

    public void sort() {
        List<Movie> slist = movies;
        List<Movie> sortedList = slist.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);

    }
    public void add(Movie movie)
    {
        movies.add(movie);
    }

    public void printChart()
    {
        for (Movie movie: movies) {
            System.out.println(movie);
        }
    }


}
