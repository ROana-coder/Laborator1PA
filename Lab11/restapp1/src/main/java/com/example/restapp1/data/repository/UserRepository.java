package com.example.restapp1.data.repository;


import com.example.restapp1.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Optional;

@RepositoryRestResource(exported = true)
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String userName);

}

