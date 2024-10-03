package com.springproject.demo.Controller;

//import com.springproject.demo.ServiceMain.RoleService;
import com.springproject.demo.ServiceMain.RoleService;
import com.springproject.demo.ServiceMain.UserService;
import com.springproject.demo.domain.Role;
import com.springproject.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
     private RoleService roleService;
    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
       User user= this.userService.getUser(username);
       return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User>users=this.userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{roleName}")
    public List<User>getRole(@PathVariable String roleName) {
//        Role role=this.roleService.getRole(roleId);
//        return this.userService.getRole(role);
//        Role role=this.roleService.getRole(roleName);
//        return this.userService.getUserByRole(role.getRoleName());

        Role role=this.roleService.getRole(roleName);
        return this.userService.findByRole(role);
    }

//    @GetMapping("/users/{roleName}")
//    public ResponseEntity<List<User>> getRole(@PathVariable String roleName) {
//        System.out.println("Role name requested: " + roleName);
//        List<User> users = this.userService.getUserByRole(roleName);
//        System.out.println("retrieved user :"+users);
//        return new ResponseEntity<>(users, HttpStatus.OK);
//
//    }


}
