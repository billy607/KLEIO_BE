package com.kleio.app.service.Impl;

import com.kleio.app.repository.UserRepository;
import com.kleio.app.entities.User;
import com.kleio.app.dto.UpdateRequest;
import com.kleio.app.dto.UserRequest;
import com.kleio.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public boolean addUser(UserRequest userRequest) {
        try {
            userRepository.save(convertToUser(userRequest));
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

    @Override
    public boolean userLogin(UserRequest userRequest) {
        return Objects.nonNull(userRepository.getIdByNameAndPwd(userRequest.getName(), userRequest.getPassword()));
    }

    private User convertToUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        return user;
    }
}
