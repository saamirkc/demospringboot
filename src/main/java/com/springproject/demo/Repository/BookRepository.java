package com.springproject.demo.Repository;

import com.springproject.demo.domain.Author;
import com.springproject.demo.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Books, String> {
List<Books> findByAuthor(Author author);
}
