package com.springproject.demo.ServiceMain.ServiceMainImpl;

import com.springproject.demo.Repository.AuthorRepository;
import com.springproject.demo.ServiceMain.AuthorService;
import com.springproject.demo.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return this.authorRepository.save(author);
    }

//    this will only find the author from id it doent do beyond that
//    @Override
//    public Author getAuthor(Long id) {
//        return this.authorRepository.findById(id).get();
//    }


//   this will do same as above(finding author by id) plus it will return null if id not found
//    @Override
//    public Author getAuthor(Long id) {
//            return this.authorRepository.findById(id).orElse(null);
//    }


    @Override
    public Author getAuthor(Long id) {
        Optional<Author> author = this.authorRepository.findById(id);
        return author.orElseThrow(()-> new RuntimeException("Author with id " + id + " not found"));
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        if(this.authorRepository.existsById(author.getId())){
            return this.authorRepository.save(author);
        }
        else{
            throw new RuntimeException("Author with id " + author.getId() + " not found");
        }

//        return this.authorRepository.save(author);
    }
}
