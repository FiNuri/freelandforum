package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.User;

import java.util.List;

public interface UserDao {

    String createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    String updateById(int id);

    String dropUserById(int id);

}
