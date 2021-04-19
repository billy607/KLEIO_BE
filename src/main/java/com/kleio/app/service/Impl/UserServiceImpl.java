package com.kleio.app.service.Impl;

import com.kleio.app.dao.UserRepository;
import com.kleio.app.entities.User;
import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.dto.UserRequestTest;
import com.kleio.app.service.userService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements userService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public boolean addUser(UserRequestTest userRequestTest) {
        try {
            userRepository.save(convertToUser(userRequestTest));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getByUserId(userId);
    }

    @Override
    public boolean deleteUser(int userId) {
        try {
            userRepository.deleteByUserId(userId);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public User updateUser(UpdateRequest updateRequest) {
        userRepository.updateByUserId(updateRequest.getUserId(), updateRequest.getName(), updateRequest.getPassword());
        return userRepository.getByUserId(updateRequest.getUserId());
    }

    private User convertToUser(UserRequestTest userRequestTest) {
        User user = new User();
        user.setUserName(userRequestTest.getName());
        user.setPassword(userRequestTest.getPassword());
        return user;
    }
}
