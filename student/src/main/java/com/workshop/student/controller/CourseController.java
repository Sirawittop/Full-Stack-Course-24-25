package com.workshop.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.workshop.student.entity.courseEntity;
import com.workshop.student.service.CourseService;



@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- CourseController getAll() -----");

        List<courseEntity> courseList = courseService.getAllCourse();
        System.out.println("----- CourseController getAll Course -----");
        System.out.println("Size: " + courseList.size());

        return "index";
    }

    @GetMapping("/{course-id}")
    public String getById(
        @PathVariable(name = "course-id", required = true) Integer courseId) {
        System.out.println("----- CourseController getById() -----");
        System.out.println("Course ID: " + courseId);

        courseEntity course = courseService.getCourseById(courseId);
        System.out.println("----- CourseController getById Course -----");
        System.out.println("Course Name: " + course.getCourseName());

        return "index";
    }
    
    @GetMapping("/delete/{course-id}")
    public String getDeleteById(
        @PathVariable(name = "course-id", required = true) Integer courseId) {
        System.out.println("----- CourseController getDeleteById() -----");
        System.out.println("Course ID: " + courseId);

        courseEntity course = courseService.getCourseById(courseId);
        System.out.println("----- CourseController getDeleteById Course -----");
        System.out.println("Course Name: " + course.getCourseName());
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String> params) {
        System.out.println("----- CourseController postInsertAndUpdate() -----");
        System.out.println("Params id : " + params.get("course-id"));
        System.out.println("Params code : " + params.get("course-name"));
        System.out.println("Params code : " + params.get("course-description"));

        System.out.println("----- CourseController postInsertAndUpdate Course -----");
        courseEntity course = new courseEntity();
        if (null != params.get("course-id") ){
            course.setCourseId(Integer.parseInt(params.get("course-id")));
        }

        course.setCourseName(params.get("course-name"));
        course.setCourseDescription(params.get("course-description"));
        courseEntity result = courseService.saveCourse(course);
        System.out.println("Course ID: " + result.getCourseId());
        System.out.println("Course Name: " + result.getCourseName());

        return "index";
    }
}
