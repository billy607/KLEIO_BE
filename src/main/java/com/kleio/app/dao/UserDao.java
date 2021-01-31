package com.kleio.app.dao;

import com.kleio.app.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    boolean insertUser(UUID id, User user);

    default boolean insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> getAllUser();

    User getUser(UUID userId);

    boolean deleteUser(UUID userId);

    User updateUser(User user);
}
