package com.kleio.app.controller;

import com.kleio.app.dto.UserRequest;
import com.kleio.app.entities.User;
import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping(path = "api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(path = "/add", name = "adding new user")
    public boolean addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping(path ="/getAllUser", name = "get all user")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping(path = "/{userId}")
    public boolean deleteUser(@PathVariable("userId") int userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping(path = "/update", name = "update current user")
    public User updateUser(@RequestBody UpdateRequest updateRequest) {
        return userService.updateUser(updateRequest);
    }

    @PostMapping(path = "/login", name = "login to app")
    public boolean login(@RequestBody UserRequest userRequest) {
        return userService.userLogin(userRequest);
    }

}
