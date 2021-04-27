package com.example.lab9.entity;




import com.example.lab9.DataTransferObject;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@NamedQueries({
        @NamedQuery(name = "Movie.findByTitle", query = "SELECT a FROM Movie a WHERE a.title LIKE :title"),
        @NamedQuery(name = "Movie.findById", query = "SELECT a FROM Movie a WHERE a.id = :id")
})

public class Movie implements DataTransferObject, Comparable<Movie> {

    public Movie(int id, String title, int releaseDate, int duration, int score) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private int releaseDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "score")
    private int score;

    public Movie(String title, int release_date, int duration, int score) {
        this.title = title;
        this.releaseDate = release_date;
        this.duration = duration;
        this.score = score;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        if (getScore() < o.getScore()) return -1;
        else if (getScore() > o.getScore()) return 1;
        else return 0;
    }

}
