package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public List<User> findAllUsers();
}
