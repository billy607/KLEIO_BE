package com.kleio.app.dao;

import com.kleio.app.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public boolean insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName()));
        return true;
    }

    @Override
    public List<User> getAllUser() {
        return DB;
    }

    @Override
    public User getUser(UUID userId) {
        Optional<User> u = DB.stream().filter(user -> user.getId().equals(userId)).findFirst();
        return u.orElse(null);
    }

    @Override
    public boolean deleteUser(UUID userId) {
        List<User> userList = DB.stream().dropWhile(user -> user.getId().equals(userId)).collect(Collectors.toList());
        if (userList.size() == DB.size()) {
            return false;
        } else {
            DB = userList;
            return true;
        }
    }

    @Override
    public User updateUser(User targetUser) {
        for (User user:DB) {
            if (user.getId().equals(targetUser.getId())) {
                user.setName(targetUser.getName());
                return user;
            }
        }
        return null;
    }
}
