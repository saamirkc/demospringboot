package com.springproject.demo.Controller;

import com.springproject.demo.ServiceMain.UserService;
import com.springproject.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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
}
