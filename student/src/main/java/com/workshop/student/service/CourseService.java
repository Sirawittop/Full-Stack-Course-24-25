package com.workshop.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.courseEntity;
import com.workshop.student.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    public List<courseEntity> getAllCourse() {
        return courseRepository.findAll();
    }

    public courseEntity getCourseById(Integer courseId) {
        Optional<courseEntity> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return course.get();
        } else {
            return null;
        }
    }

    public courseEntity saveCourse(courseEntity course) {
        courseEntity newCourse = courseRepository.save(course);
        return newCourse;
    }

    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
