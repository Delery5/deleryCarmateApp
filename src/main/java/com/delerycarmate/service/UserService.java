package com.delerycarmate.service;


import com.delerycarmate.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserById(int id);

    User findById(int id);

    void updateUser(User user);
}

