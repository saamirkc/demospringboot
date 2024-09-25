package com.springproject.demo.Controller;

import com.springproject.demo.ServiceMain.BookService;
import com.springproject.demo.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
@Autowired
private BookService bookService;
//adding books.
@PostMapping("/")
    public Books addBook(@RequestBody Books book) {
    return this.bookService.addBook(book);
}
//  @RequestBody  is primarily used in RESTFul web services to convert the incoming JSON data from the request body into a Java object.
//For egWhen a client sends an HTTP request with a JSON payload, Spring uses a message converter (like Jackson) to deserialize the JSON into a specified Java object type.
//in short @RequestBody annotations convert JSON request sent by client to Java objects
//in above post mapping when the client i.e. front end sends the data in the form of JSON the @RequestBOdy converts JSON into Java Books object.
//the data entered by client is saved in book object which is saved in the database.


//getting books by isbn
//@GetMapping("/{isbn}")
//    public Books getBook(@PathVariable String isbn) {
//    return this.bookService.getBook(isbn);
//}
//this can also be done by :
    @GetMapping("/{isbn}")
    public ResponseEntity<Books> getBook(@PathVariable String isbn) {
    Books book=this.bookService.getBook(isbn);
    return new ResponseEntity<>(book, HttpStatus.OK);
    }
//    this method is more flexible as his method returns a ResponseEntity<Books>, which is a more detailed structure used to
//    represent the entire HTTP response.
//    and @Path variable annotations is used since we passes path which is {/isbn}.

//    getting all books.
    @GetMapping("/")
    public List<Books>  getAllBooks() {
    return this.bookService.getAllBooks();
    }
//here we need to any annotations because :
// 1.for  Saving a Book (Java Object):
//When the frontend sends a JSON request (via POST), @RequestBody converts the JSON into a Java Books object.
//
//2. Viewing a Book (Java to JSON):
//When the frontend sends a GET request to view the book, Spring Boot converts the Java Books object back to JSON format automatically.

//    deleting  book by isbn
@DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
    this.bookService.deleteBook(isbn);
}
//updating book
    @PutMapping("/")
    public Books updateBook(@RequestBody Books book) {
    return this.bookService.updateBook(book);
    }
}

