package com.springproject.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String profile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role", // The name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // The foreign key column for User
            inverseJoinColumns = @JoinColumn(name = "role_id") // The foreign key column for Role
    )
//    @JsonBackReference
    private List<Role> roles=new ArrayList<>();

}
