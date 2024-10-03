package com.springproject.demo.Repository;

import com.springproject.demo.domain.Role;
import com.springproject.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    public List<User> findByRoles(Role role);
}
