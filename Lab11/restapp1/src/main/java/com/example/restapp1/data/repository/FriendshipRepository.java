package com.example.restapp1.data.repository;


import com.example.restapp1.data.entity.Friendship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

}
