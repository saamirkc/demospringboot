package com.springproject.demo.Controller;
import com.springproject.demo.ServiceMain.AuthorService;
import com.springproject.demo.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    //    adding author
    @PostMapping("/")
    public Author addAuthor(@RequestBody Author author) {
        return this.authorService.addAuthor(author);
    }

//    getting author by author id
//    @GetMapping("{/id"})
//    public Author getAuthor(@PathVariable long id) {
//        return this.authorService.getAuthor(id);
//    }

    //    another way
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Author author = this.authorService.getAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    //    getting all authors
    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    //    updating authors
    @PutMapping("/")
    public Author updateAuthor(@RequestBody Author author) {
        return this.authorService.updateAuthor(author);
    }

    //    deleting author by id
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        this.authorService.deleteAuthor(id);
    }

//can be done as below too .
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
//        this.authorService.deleteAuthor(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No content to return
//    }

//  but remember there will be no return type if you want to delete something from database


}
