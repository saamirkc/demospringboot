package com.springproject.demo.Repository;

import com.springproject.demo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

//    custom query can be defined here if needed
}

//Custom query methods in Spring Data repositories are useful when you need to perform specific queries
// that are not covered by the default CRUD operations provided by interfaces like JpaRepository or CrudRepository.
//example where custom query is needed :
//finding user with a specific role and status
//counting no. of orders for a particular customer
//searching and filtering(Searching for books by title or author)
//sorting and pagenation
//in the above case normal CRUD operation cant perform above function so custom query is needed.