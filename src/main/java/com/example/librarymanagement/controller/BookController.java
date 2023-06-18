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
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@CrossOrigin

public class BookController {
   private final BookService bookService;

   @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id)
    {
      return ResponseEntity.ok(bookService.getBookById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book){
        
        return ResponseEntity.ok(bookService.createBook(book));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book Deleted");
    }

    @PutMapping("/{id}")
    
     public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable Long id){
        return ResponseEntity.ok(bookService.updateBook(id, book));
     }


    
}
