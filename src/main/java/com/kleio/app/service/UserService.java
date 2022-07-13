package com.kleio.app.service;

import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.dto.UserRequest;
import com.kleio.app.entities.User;

import java.util.List;

public interface UserService {
    boolean addUser(UserRequest userRequest);

    List<User> getAllUser();

    User getUser(int userId);

    boolean deleteUser(int userId);

    User updateUser(UpdateRequest updateRequest);

    boolean userLogin(UserRequest userRequest);
}
