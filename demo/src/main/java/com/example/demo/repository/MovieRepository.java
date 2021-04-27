package com.example.demo.repository;

import com.example.demo.Movie;
import com.example.demo.MovieMoviesEntity;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MovieRepository {

    public void createMovie(MovieMoviesEntity movie){
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        //movie.setId(5);
        //movie.setTitle("Mamamia");

        entityManager.merge(movie);
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
