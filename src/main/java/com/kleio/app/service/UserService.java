package com.kleio.app.service;

import com.kleio.app.dao.UserDao;
import com.kleio.app.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    @Qualifier("fakeDao")
    private final UserDao userDao;

    public boolean addUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUser(UUID userId) {
        return userDao.getUser(userId);
    }

    public boolean deleteUser(UUID userId) {
        return userDao.deleteUser(userId);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }
}
