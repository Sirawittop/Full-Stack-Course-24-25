package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- getAll -----");
        return "index";
    }

    @GetMapping("/{faculty-id}")
    public String getById(
        @PathVariable(name = "faculty-id", required = true) Integer facultyId) {
        System.out.println("----- getById -----");
        System.out.println("Faculty ID: " + facultyId);
        return "index";
    }

    @PostMapping("/")
    public String postInsertAadUpdate(
        @RequestParam() Map<String, String> params) {
        System.out.println("----- postInsertAadUpdate -----");
        System.out.println("Params id : " + params.get("faculty-id"));
        System.out.println("Params code : " + params.get("faculty-name"));
        return "index";
    }
    

    @GetMapping("/delete/{faculty-id}")
    public String getDeleteById(
        @PathVariable(name = "faculty-id" , required = true) Integer facultyId) {
        System.out.println("----- getDeleteById -----");
        System.out.println("Faculty ID: " + facultyId);
        return "index";
    }
}
