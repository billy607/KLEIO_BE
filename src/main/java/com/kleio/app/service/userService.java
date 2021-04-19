package com.kleio.app.service;

import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.dto.UserRequestTest;
import com.kleio.app.entities.User;

import java.util.List;

public interface userService {
    boolean addUser(UserRequestTest userRequestTest);

    List<User> getAllUser();

    User getUser(int userId);

    boolean deleteUser(int userId);

    User updateUser(UpdateRequest updateRequest);
}
