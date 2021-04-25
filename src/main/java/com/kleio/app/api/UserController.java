package com.kleio.app.api;

import com.kleio.app.entities.User;
import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.dto.UserRequestTest;
import com.kleio.app.service.Impl.UserServiceImpl;
import com.kleio.app.service.Impl.s3ServiceImpl;
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
    private final UserServiceImpl userServiceImpl;

    @Autowired
    private final s3ServiceImpl s3;

    @PostMapping(path = "/add", name = "adding new user")
    public boolean addUser(@RequestBody UserRequestTest userRequestTest) {
        return userServiceImpl.addUser(userRequestTest);
    }

    @GetMapping(path ="/getAllUser", name = "get all user")
    public List<User> getAllUser() {
        return userServiceImpl.getAllUser();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userServiceImpl.getUser(userId);
    }

    @DeleteMapping(path = "/{userId}")
    public boolean deleteUser(@PathVariable("userId") int userId) {
        return userServiceImpl.deleteUser(userId);
    }

    @PostMapping(path = "/update", name = "update current user")
    public User updateUser(@RequestBody UpdateRequest updateRequest) {
        return userServiceImpl.updateUser(updateRequest);
    }

}
