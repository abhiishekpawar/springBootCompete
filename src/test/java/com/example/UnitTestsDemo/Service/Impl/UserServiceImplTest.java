package com.example.UnitTestsDemo.Service.Impl;

import com.example.UnitTestsDemo.Entity.User;
import com.example.UnitTestsDemo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void save() {
        //arrange
        User user = new User();
        user.setName("user1");
        when(userRepository.save(any(User.class))).thenReturn(user);

        //act
        User savedUser = userService.save(user);

        //assert
        //assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getName().equals(user.getName()));
    }

    @Test
    void getAllUsers() {

        //arrange
        User user1 = new User();
        user1.setName("user1");
        User user2 = new User();
        user2.setName("user2");
        List<User> userList = Arrays.asList(user1,user2);
        when(userRepository.findAll()).thenReturn(userList);

        //act
        List<User> savedUser = userService.getAllUsers();

        //assert
        assertNotNull(savedUser);
        assertNotNull(savedUser.get(0).getName().equals("user2"));
        assertEquals(savedUser.size(),2);

    }

    @Test
    void getById() {

    }

    @Test
    void updateById() {
        //arrange
        //User user = new User(1,"user")
    }

    @Test
    void deleteAll() {
//        User user1 = new User();
//        user1.setName("user1");
//        User user2 = new User();
//        user2.setName("user2");
//        List<User> userList = Arrays.asList(user1,user2);
//        when(userRepository.findAll()).thenReturn(userList);
//
//        //act
//        userService.deleteAll();
//        // Verify that the findAll method of the repository is called
//        verify(userRepository,times(1)).findAll();
//        // Verify that the deleteAll method of the repository is callee
//        verify(userRepository,times(1)).deleteAll();
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByName() {
        //arrange
        User user1 = new User(1,"user1");
        when(userRepository.findByName(any())).thenReturn(user1);

        //act
        User user = userService.findByName(user1.getName());

        //assert
        assertNotNull(user);
        assertEquals("user1",user.getName());
        verify(userRepository,times(1)).findByName(any());

    }
}