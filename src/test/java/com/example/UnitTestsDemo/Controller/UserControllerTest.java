package com.example.UnitTestsDemo.Controller;


import com.example.UnitTestsDemo.Entity.User;
import com.example.UnitTestsDemo.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    UserService userService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void save() throws Exception {
        //arrange
        User user = User.builder().id(1).name("user1").build();
        when(userService.save(user)).thenReturn(user);

        //act & Assert
        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                        .andExpect(status().isCreated());
    }

    @Test
    void getAll() throws Exception {
        User user1 = User.builder().id(1).name("user1").build();
        User user2 = User.builder().id(2).name("user2").build();
        List<User> users = Arrays.asList(user1,user2);

        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/getAll")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(users)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value(user1));
    }

    @Test
    void getById() throws Exception {
        User user = User.builder().id(1).name("Test1").build();
        when(userService.getById(user.getId())).thenReturn(user);

        mockMvc.perform(get("/get/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test1"));
    }

    @Test
    void update() throws Exception {
        User user = User.builder().id(1).name("Test2").build();
        when(userService.updateById(user)).thenReturn(user);

        mockMvc.perform(put("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test2"));

    }

    @Test
    void delete() {
    }

    @Test
    void getUserByName() throws Exception{
        User user = User.builder().id(1).name("Test2").build();
        when(userService.findByName(user.getName())).thenReturn(user);

        mockMvc.perform(get("/name/{name}",user.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());

    }
}