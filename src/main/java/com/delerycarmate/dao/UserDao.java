package com.delerycarmate.dao;

import com.delerycarmate.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserById(int id);

    User findById(int id);

    void updateUser(User user);
}

