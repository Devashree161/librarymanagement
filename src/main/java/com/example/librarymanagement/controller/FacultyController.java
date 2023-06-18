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
import com.example.librarymanagement.entity.Faculty;
import com.example.librarymanagement.service.FacultyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
@CrossOrigin

public class FacultyController {
   private final FacultyService facultyService;

   @GetMapping()
    public ResponseEntity<?> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable Long id)
    {
      return ResponseEntity.ok(facultyService.getFacultyById(id));
    }
    
    @PostMapping
    public ResponseEntity<?> createFaculty(@RequestBody Faculty faculty){
        
        
        return ResponseEntity.ok(facultyService.createFaculty(faculty));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok("Faculty Deleted");
    }

    @PutMapping("/{id}")
    
     public ResponseEntity<?> updateFaculty(@RequestBody Faculty faculty,@PathVariable Long id){
        return ResponseEntity.ok(facultyService.updateFaculty(id, faculty));
     }


    
}
