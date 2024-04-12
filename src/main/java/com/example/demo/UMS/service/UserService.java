package com.example.demo.UMS.service;

import com.example.demo.UMS.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    boolean deleteUserById(int id);

    User getUserById(int id);

}
