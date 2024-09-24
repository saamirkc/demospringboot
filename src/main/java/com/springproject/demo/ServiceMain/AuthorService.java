package com.springproject.demo.ServiceMain;

import com.springproject.demo.domain.Author;

import java.util.List;

public interface AuthorService {
    public Author  addAuthor(Author author);
    public Author getAuthor(Long id);
    public List<Author> getAllAuthors();
    public void deleteAuthor(Long id);
    public Author updateAuthor(Author author);


}
