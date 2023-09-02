package org.example.service;

import org.example.entity.Customer;
import org.example.entity.User;

import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public List<User> findAllUsers();
}
