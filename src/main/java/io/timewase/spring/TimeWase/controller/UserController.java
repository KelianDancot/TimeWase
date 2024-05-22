package io.timewase.spring.TimeWase.controller;

import io.timewase.spring.TimeWase.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User getUser(){
        User myUser = new User(202020, "Vincent", "test@test.com", "1234", 2222);
        return myUser;
    }

    //public Goal getGoal(){
       // Goal myGoal = new Goal(US)
    //}
}
