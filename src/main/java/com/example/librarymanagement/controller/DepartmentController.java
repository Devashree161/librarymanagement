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

import com.example.librarymanagement.entity.Department;
import com.example.librarymanagement.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@CrossOrigin

public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable Long id)
    {
      return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> createFaculty(@RequestBody Department department){
        
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Faculty Deleted");
    }

    @PutMapping("/{id}")
    
     public ResponseEntity<?> updateDepartment(@RequestBody Department department,@PathVariable Long id){
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
     }
    
}
