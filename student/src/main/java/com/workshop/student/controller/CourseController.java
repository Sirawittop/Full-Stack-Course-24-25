package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/course")
public class CourseController {

    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- CourseController getAll() -----");
        return "index";
    }

    @GetMapping("/{course-id}")
    public String getById(
        @PathVariable(name = "course-id", required = true) Integer courseId) {
        System.out.println("----- CourseController getById() -----");
        System.out.println("Course ID: " + courseId);
        return "index";
    }
    
    @GetMapping("/delete/{course-id}")
    public String getDeleteById(
        @PathVariable(name = "course-id", required = true) Integer courseId) {
        System.out.println("----- CourseController getDeleteById() -----");
        System.out.println("Course ID: " + courseId);
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String> params) {
        System.out.println("----- CourseController postInsertAndUpdate() -----");
        System.out.println("Params id : " + params.get("course-id"));
        System.out.println("Params code : " + params.get("course-name"));
        System.out.println("Params code : " + params.get("course-description"));
        return "index";
    }
}
