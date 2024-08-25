package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.StudentEntity;
import com.workshop.student.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Integer studentId) {
        Optional<StudentEntity> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    public StudentEntity saveStudent(StudentEntity student) {
        StudentEntity newStudent = studentRepository.save(student);
        return newStudent;
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
