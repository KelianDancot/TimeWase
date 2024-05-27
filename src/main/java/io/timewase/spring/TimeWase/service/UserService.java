package io.timewase.spring.TimeWase.service;

import io.timewase.spring.TimeWase.model.User;
import io.timewase.spring.TimeWase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return repo.findById(userId);
    }

    public User saveUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(Long userId) {
        repo.deleteById(userId);
    }
}
