package com.kleio.app.dao;

import com.kleio.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("DELETE FROM User u where u.userId = :userId")
    void deleteByUserId(@Param("userId") int userId);

    User getByUserId(int userId);

    @Modifying
    @Query("UPDATE User u SET u.userName = :userName, u.password = :password where u.userId = :userId")
    void updateByUserId(@Param("userId")int userId, @Param("userName")String name, @Param("password")String password);
}
