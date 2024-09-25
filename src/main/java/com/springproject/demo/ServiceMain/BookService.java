package com.springproject.demo.ServiceMain;
import com.springproject.demo.domain.Author;
import com.springproject.demo.domain.Books;

import java.util.List;

public interface BookService {
    public Books addBook(Books book);
    public Books updateBook(Books book);


  public  void deleteBook(String isbn);

    public Books getBook(String isbn);
    public List<Books> getAllBooks();
    public List<Books> getBooksByAuthor(Author author);

}
