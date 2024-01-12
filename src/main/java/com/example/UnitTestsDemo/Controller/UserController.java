package com.example.UnitTestsDemo.Controller;

import com.example.UnitTestsDemo.Entity.User;
//import com.example.UnitTestsDemo.Exception.UserNotFoundException;
import com.example.UnitTestsDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User user1 = userService.save(user);

        if (user1 != null)
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        User user1 = userService.updateById(user);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        userService.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        return new ResponseEntity<>(userService.findByName(name),HttpStatus.OK);
    }


}
