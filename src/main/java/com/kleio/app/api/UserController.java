package com.kleio.app.api;

import com.kleio.app.entities.User;
import com.kleio.app.model.UpdateRequest;
import com.kleio.app.model.UserRequestTest;
import com.kleio.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(path = "/add", name = "adding new user")
    public boolean addUser(@RequestBody UserRequestTest userRequestTest) {
        return userService.addUser(userRequestTest);
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
}
