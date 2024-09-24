package com.springproject.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)    //cascade = CascadeType.ALL means deleting author results in deleting all books written by author
    private List<Books> books = new ArrayList<>();


}
//@Entity
//This annotation marks a class as a JPA entity, which means that it will be mapped to a database table.
//The class must have a no-argument constructor and must be public or protected.
//2. @Id
//This annotation indicates the primary key of the entity. Every entity must have a primary key that uniquely identifies each instance of the entity in the database.
//It is used to mark the field that will serve as the identifier for the entity.
//3. @GeneratedValue
//This annotation specifies how the primary key value is generated.
//The strategy attribute allows you to define the primary key generation strategy. The common strategies are:
//GenerationType.IDENTITY: The database generates a unique value for the primary key. This is often used with auto-incrementing columns in databases like MySQL.
//GenerationType.AUTO: The persistence provider (like Hibernate) selects the appropriate strategy for the specific database.
//GenerationType.SEQUENCE: A database sequence is used to generate the primary key value. This is common in databases like PostgreSQL or Oracle.
//GenerationType.TABLE: A separate table is used to generate the primary key values.