package com.delerycarmate.service.impl;

import com.delerycarmate.dao.UserDao;
import com.delerycarmate.model.User;
import com.delerycarmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public void deleteUserById(int id) {
        dao.deleteUserById(id);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }
}

