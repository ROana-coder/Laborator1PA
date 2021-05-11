package com.company;

import java.util.ArrayList;

public class Friend {

    public ArrayList<String> AddFriends(String name, ArrayList<String> friends)
    {
        friends.add(name);
        return friends;
    }
    public ArrayList<String> AddFriends(ArrayList<String> names, ArrayList<String> friends)
    {
        for (String name: names) {
            friends.add(name);
        }
        return friends;
    }

//    public void FriendCommand(ArrayList<String> names)
//    {
//
//    }
}
