package com.springproject.demo.Repository;

import com.springproject.demo.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Books, String> {

}
