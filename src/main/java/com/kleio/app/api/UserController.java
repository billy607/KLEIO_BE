package com.kleio.app.api;

import com.kleio.app.model.User;
import com.kleio.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = "api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(path = "/add", name = "adding new user")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping(path ="/getAllUser", name = "get all user")
    public List<User> gerAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") UUID userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping(path = "/{userId}")
    public boolean deleteUser(@PathVariable("userId") UUID userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping(path = "/update", name = "update current user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
