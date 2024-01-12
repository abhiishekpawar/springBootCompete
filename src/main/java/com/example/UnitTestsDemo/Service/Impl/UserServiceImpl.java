package com.example.UnitTestsDemo.Service.Impl;

import com.example.UnitTestsDemo.Entity.User;
import com.example.UnitTestsDemo.Repository.UserRepository;
import com.example.UnitTestsDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).get();

    }

    @Override
    public User updateById(User user) {
        User existingUser = repository.findById(user.getId()).get();
        existingUser.setId(existingUser.getId());
        existingUser.setName(existingUser.getName());
        return existingUser;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }
}
