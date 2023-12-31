package com.example.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            existingStudent.setYear(updatedStudent.getYear());
            existingStudent.setDivision(updatedStudent.getDivision());
            return studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
