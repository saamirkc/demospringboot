package com.springproject.demo.ServiceMain.ServiceMainImpl;

import com.springproject.demo.Repository.BookRepository;
import com.springproject.demo.ServiceMain.BookService;
import com.springproject.demo.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;


    @Override
    public Books addBook(Books book) {
        return this.bookRepository.save(book);
    }


    @Override
    public Books getBook(String isbn) {
        Optional<Books> book=this.bookRepository.findById(isbn);
        return book.orElseThrow(()->new RuntimeException("Books with ISBN " + isbn + " not found"));


    }

    @Override
    public List<Books> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deleteBook(String isbn) {
    this.bookRepository.deleteById(isbn);
    }

    @Override
    public Books updateBook(Books book) {
       if(this.bookRepository.existsById(book.getIsbn())){
           return this.bookRepository.save(book);
        }
        else{
            throw new RuntimeException("Books with ISBN " + book.getIsbn() + " not found");
        }
    }
}
