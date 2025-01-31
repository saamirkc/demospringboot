package com.springproject.demo.Controller;

import com.springproject.demo.ConfigforJWT.JWTRequest;
import com.springproject.demo.ConfigforJWT.JWTResponse;
import com.springproject.demo.ConfigforJWT.JwtUtils;
import com.springproject.demo.ServiceMain.ServiceMainImpl.UserDetailsServiceImpl;
import com.springproject.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    //generate  token
    @PostMapping("/generate-token")

    public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch(UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not found");
        }
//authentication done
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }



    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER DISABLED"+e.getMessage());
        }catch(BadCredentialsException e){
            throw new Exception("Invalid Credentials"+e.getMessage());
        }

    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));

    }

}
