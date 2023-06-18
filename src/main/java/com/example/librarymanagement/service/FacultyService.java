package com.example.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.entity.Faculty;
import com.example.librarymanagement.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Optional<Faculty> existingFacultyOptional = facultyRepository.findById(id);
        if (existingFacultyOptional.isPresent()) {
            Faculty existingFaculty = existingFacultyOptional.get();
            existingFaculty.setName(updatedFaculty.getName());
            existingFaculty.setDepartment(updatedFaculty.getDepartment());
            return facultyRepository.save(existingFaculty);
        } else {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
