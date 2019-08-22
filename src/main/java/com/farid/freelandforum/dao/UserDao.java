package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.User;

import java.util.List;

public interface UserDao {

    String createUser(User user) throws DaoExeption;

    User getUserById(int id) throws DaoExeption;

    List<User> getAllUsers() throws DaoExeption;

    String updateById(int id) throws DaoExeption;

    String dropUserById(int id) throws DaoExeption;

}
