package com.handson.labs.graphql.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.service.AuthorService;

@RestController
@RequestMapping("/v1/authors")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;


    @GetMapping("/get-author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        return new ResponseEntity<Author>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PutMapping("/save-author/{id}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable Integer id, @RequestBody Author author) {
        authorService.saveAuthor(author);
        Author geAuthor = authorService.getAuthorById(id);
        return new ResponseEntity<Author>(geAuthor, HttpStatus.OK);
    }

    @PostMapping("/create-author")
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return new ResponseEntity<>("Author created successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<String> deletAUthor(@PathVariable String id) {
        authorService.deleteAuthorById(null);
        return new ResponseEntity<>("Author Deleted Successfully.", HttpStatus.valueOf(202));
    }

}
