package com.example.librarymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.librarymanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}