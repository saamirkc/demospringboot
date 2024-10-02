package com.springproject.demo.ServiceMain;

import com.springproject.demo.domain.User;

public interface UserService {
    public User addUser(User user);

    public User getUser(String username);

    public void deleteUser(Long id);


}
