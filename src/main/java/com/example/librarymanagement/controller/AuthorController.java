package com.example.librarymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.librarymanagement.service.AuthorService;
import com.example.librarymanagement.entity.Author;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
@CrossOrigin

public class AuthorController {
    private final AuthorService authorService;

    
    @GetMapping()
    public ResponseEntity<?> getAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id)
    {
      return ResponseEntity.ok(authorService.getAuthorById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.createAuthor(author));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author Deleted");
    }

    @PutMapping("/{id}")
    
     public ResponseEntity<?> updateAuthor(@RequestBody Author author,@PathVariable Long id){
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
     }


  
}
