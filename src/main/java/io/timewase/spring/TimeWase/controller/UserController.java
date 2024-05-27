package io.timewase.spring.TimeWase.controller;

import io.timewase.spring.TimeWase.model.User;
import io.timewase.spring.TimeWase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;


    @CrossOrigin("*")
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setUserId(id);
        return service.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
