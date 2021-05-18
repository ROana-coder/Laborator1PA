package com.example.restapp1.business.service;

import com.example.restapp1.data.entity.Friendship;
import com.example.restapp1.data.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<Friendship> getFriendships(){
        Iterable<Friendship> friendships = this.friendshipRepository.findAll();
        return (List<Friendship>) friendships;
    }

    public Optional<Friendship> findById(int id)
    {
        return friendshipRepository.findById((long) id);
    }

    public Iterable<Friendship> findAll()
    {
        return friendshipRepository.findAll();
    }

    public Friendship save(Friendship friendship) {
        friendshipRepository.save(friendship);
        return friendship;
    }

    public void remove(long id) {
        friendshipRepository.deleteById(id);
    }

    public Friendship update(Friendship newFriendship, long id) {
        return friendshipRepository.findById(id)
                .map(friendship -> {
                    friendship.setName1(newFriendship.getName1());
                    friendship.setName2(newFriendship.getName2());
                    return friendshipRepository.save(friendship);
                })
                .orElseGet(() -> {
                    newFriendship.setId(id);
                    return friendshipRepository.save(newFriendship);
                });
    }

    public List<Optional<Friendship>> findByName(String name) {
        return findByName(name);
    }
}
