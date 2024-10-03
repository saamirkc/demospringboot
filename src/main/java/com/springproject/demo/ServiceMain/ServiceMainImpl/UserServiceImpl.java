package com.springproject.demo.ServiceMain.ServiceMainImpl;

import com.springproject.demo.Repository.UserRepository;
import com.springproject.demo.ServiceMain.UserService;
import com.springproject.demo.domain.Role;
import com.springproject.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
    User user1= this.userRepository.findByUsername(user.getUsername());
    if(user1==null){
//        add new user:
        user1=this.userRepository.save(user);
    }
    else{
        throw new RuntimeException("User already exists");
    }
    return user1;

    }
    //here look at user service impl of exam portal backend .Since it uses intermediate userrole class for mapping between user and
//    role so you have to explicitly manage the relationship between User and Role. This means when you create a user, you will
//    also need to create or specify UserRole objects that link the user to their respective roles. so user role is also added ans saved.

//    but here we are using direct mapping between user and role .so no need to save role while saving user as saving user can also
//    save role because of JPA mapping between user and role.

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> findByRole(Role role) {
        return this.userRepository.findByRoles(role);
    }

//    @Override
//    public List<User> getUserByRole(String roleName) {
//        List<User> users= this.userRepository.findByRoles_RoleName(roleName);
//        System.out.println("Retrieved users: " + users);
//        if(users==null){
//            throw new RuntimeException("User does not exist");
//        }
//        return users;
//    }


}
