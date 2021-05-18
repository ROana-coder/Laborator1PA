package com.example.restapp1.web;

import com.example.restapp1.business.service.FriendshipService;
import com.example.restapp1.data.entity.Friendship;
import com.example.restapp1.data.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/friendships/api")
public class FriendshipController {

        private final FriendshipService friendshipService;

        private final List<Friendship> friendships = new ArrayList<>();

        @Autowired
        public FriendshipController(FriendshipService friendshipService)
        {
            this.friendshipService = friendshipService;
        }

        @GetMapping("/friendships")
        public Iterable<Friendship> getFriendshipService() {
            //List<Person> persons =
            return friendshipService.getFriendships();
        }

        @GetMapping("/count")
        public int countFriendships() {
            return friendships.size();
        }

        @GetMapping("/person/count/{name}")
        public int countPersonFriendships(@PathVariable("name") String name) {
            int nr = 0;
            Iterable<Friendship> friendships1 = friendshipService.getFriendships();
            for (Friendship friendship : friendships1) {
                if(name.equals(friendship.getName1())) nr++;
            }
            return nr;
        }

        @GetMapping("/leastPopularPerson")
        public String leastPopular() {
            int minim = 9999;
            String name = null;
            Iterable<Friendship> friendships1 = friendshipService.getFriendships();
            for (Friendship friendship : friendships1) {
                int nr  = 0;
            for (Friendship friendship2 : friendships1) {
                if(friendship.getName1().equals(friendship2.getName1())) nr++;
            }
            if(nr < minim)
            {
                minim = nr;
                name = friendship.getName1();
            }
            }
            return name + minim;
        }

    @GetMapping("/mostPopularPerson")
    public String mostPopular() {
        int maxim = 0;
        String name = null;
        Iterable<Friendship> friendships1 = friendshipService.getFriendships();
        for (Friendship friendship : friendships1) {
            int nr  = 0;
            for (Friendship friendship2 : friendships1) {
                if(friendship.getName1().equals(friendship2.getName1())) nr++;
            }
            if(nr > maxim)
            {
                maxim = nr;
                name = friendship.getName1();
            }
        }
        return name + maxim;
    }

        @GetMapping("/person/{name}")
        public List<Optional<Friendship>> getFriendship(@PathVariable("name") String name) {
            return friendshipService.findByName(name);
        }


        @PostMapping(value = "/add", consumes="application/json")
        public Friendship createPersonInDB(@RequestBody Friendship friendship) {
            return friendshipService.save(friendship);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<String> updateProduct(
                @PathVariable int id, @RequestBody Friendship friendship) {

            Optional<Friendship> friend = friendshipService.findById((int) id);
            friendshipService.update(friendship, id);
            if (friend == null) {
                throw new CustomNotFoundException("Not found friendship with id " + id);
            }
            return new ResponseEntity<>(
                    "Friendship updated successsfully", HttpStatus.OK);
        }
        @DeleteMapping(value = "/delete/{id}")
        public ResponseEntity<String> deleteFriendship(@PathVariable long id) {
            Optional<Friendship> friendship = friendshipService.findById((int) id);
            if (friendship.isEmpty()) {
                throw new CustomNotFoundException("Not found friendship with id " + id);
            }
            friendshipService.remove(id);
            return new ResponseEntity<>("Friendship removed", HttpStatus.OK);
        }


}

