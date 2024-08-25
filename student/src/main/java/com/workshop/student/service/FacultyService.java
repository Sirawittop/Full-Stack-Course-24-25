package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyEntity> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public FacultyEntity getFacultyById(Integer facultyId) {
        Optional<FacultyEntity> faculty = facultyRepository.findById(facultyId);
        if (faculty.isPresent()) {
            return faculty.get();
        } else {
            return null;
        }
    }

    public FacultyEntity saveFaculty(FacultyEntity faculty) {
        FacultyEntity newFaculty = facultyRepository.save(faculty);
        return newFaculty;
    }

    public void deleteFaculty(Integer facultyId) {
        facultyRepository.deleteById(facultyId);
    }
    
}
