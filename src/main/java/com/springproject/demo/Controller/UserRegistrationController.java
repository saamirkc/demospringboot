//package com.springproject.demo.Controller;
//
//import com.springproject.demo.Repository.UserRepository;
//import com.springproject.demo.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class UserRegistrationController {
//@Autowired
//private UserRepository userRepository;
//
//@Autowired
//private PasswordEncoder passwordEncoder;
//
//@   PostMapping("/register")
//public ResponseEntity<?> registerUser(@RequestBody User user) {
//    // Check if user already exists
//    User user1=userRepository.findByUsername(user.getUsername());
//    if (user1==null ) {
//        return ResponseEntity.badRequest().body("User already exists");
//    }
//    // Encode password
//    user.setPassword(passwordEncoder.encode(user.getPassword()));
//    // Save user
//    userRepository.save(user);
//    return ResponseEntity.ok("User registered successfully");
//}
//}