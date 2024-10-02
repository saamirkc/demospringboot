package com.springproject.demo.ServiceMain;

import com.springproject.demo.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public User getUser(String username);

    public void deleteUser(Long id);

    public List<User> getUsers();


}
