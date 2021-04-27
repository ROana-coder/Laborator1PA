package com.example.lab9.repository;


import com.example.lab9.entity.Movie;
import com.example.lab9.util.PersistenceUtil;

import javax.persistence.*;
import java.util.List;

@PersistenceContext
public class MovieRepository {

    public void createMovie(String title, int release_date, int duration, int score){
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        Movie movie = new Movie(title, release_date, duration, score);

        entityManager.getTransaction().begin();

        entityManager.persist(movie);
        entityManager.getTransaction().commit();

        entityManager.close();
        persistenceUtil.getEntityManagerFactory().close();

    }

    public List<Movie> findByTitle(String title){
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery query = entityManager.createNamedQuery("Movie.findByTitle", Movie.class).setParameter("title", title);
        List<Movie> results = query.getResultList();
        return results;
    }

    public List<Movie> findById(int id){
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery query = entityManager.createNamedQuery("Movie.findById", Movie.class);
        query.setParameter("id", id);
        List<Movie> results = query.getResultList();
        return results;
    }
}
