package io.timewase.spring.TimeWase.service;

import io.timewase.spring.TimeWase.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeWaseService {

    static private ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "Jean", "jean.test@gmail.com", "12345", 22052024),
            new User(2, "Didier", "didier.test@gmail.com", "12345", 22052024),
            new User(3, "Pascal", "pascal.test@gmail.com", "12345", 22052024),
            new User(4, "Sabine", "sabine.test@gmail.com", "12345", 22052024),
            new User(5, "Pierre", "pierre.test@gmail.com", "12345", 22052024)
    ));

    public List<User> getUsers(){
        return users;
    }

    public User getUser(long userId) {
        return users.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
    }
}
