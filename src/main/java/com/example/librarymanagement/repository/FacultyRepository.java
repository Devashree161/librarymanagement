package com.example.librarymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.librarymanagement.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    
}