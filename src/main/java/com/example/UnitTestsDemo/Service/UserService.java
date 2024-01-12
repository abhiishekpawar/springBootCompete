package com.example.UnitTestsDemo.Service;

import com.example.UnitTestsDemo.Entity.User;
import com.example.UnitTestsDemo.Repository.UserRepository;
import com.example.UnitTestsDemo.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User save(User user);
    public List<User> getAllUsers();
    public User getById(int id);
    public User updateById(User user);
    public void deleteAll();
    public void deleteById(int id);
    public User findByName(String Name);


}
