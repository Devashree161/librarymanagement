package com.example.librarymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    
}
