package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/student")
public class StudentController {
    
    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- StudentController getAll() -----");
        return "index";
    }

    @GetMapping("/{student-id}")
    public String getById(
        @PathVariable(name = "student-id", required = true) Integer studentId) {
        System.out.println("----- StudentController getById() -----");
        System.out.println("Student ID: " + studentId);
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String > params) {
        System.out.println("----- StudentController postInsertAndUpdate() -----");
        System.out.println("Params id : " + params.get("student-id"));
        System.out.println("Params code : " + params.get("student-code"));
        System.out.println("Params code : " + params.get("student-firstname"));
        System.out.println("Params code : " + params.get("student-lastname"));
        System.out.println("Params code : " + params.get("student-faculty"));
        return "index";
    }
    

    @GetMapping("/delete/{student-id}")
    public String getDeleteById(
        @PathVariable(name = "student-id", required = true) Integer studentId) {
        System.out.println("----- StudentController getDeleteById() -----");
        System.out.println("Student ID: " + studentId);
        return "index";
    }
    
}
