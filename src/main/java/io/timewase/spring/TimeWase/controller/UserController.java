package io.timewase.spring.TimeWase.controller;

import io.timewase.spring.TimeWase.model.User;
import io.timewase.spring.TimeWase.service.TimeWaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    
    private TimeWaseService timewaseservice;

    @RequestMapping("/users")
    public List<User> getUser(){
        return timewaseservice.getUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable long UserId) {
        return timewaseservice.getUser(UserId);
    }
}
