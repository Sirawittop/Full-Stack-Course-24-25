package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/enroll")
public class EnrollController {

    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- EnrollController getAll() -----");
        return "index";
    }

    @GetMapping("/{enroll-id}")
    public String getById(
        @PathVariable(name = "enroll-id", required = true) Integer enrollId) {
        System.out.println("----- EnrollController getById() -----");
        System.out.println("Enroll ID: " + enrollId);
        return "index";
    }
    
    @GetMapping("/delete/{enroll-id}")
    public String getDeleteById(
        @PathVariable(name = "enroll-id", required = true) Integer enrollId) {
        System.out.println("----- EnrollController getDeleteById() -----");
        System.out.println("Enroll ID: " + enrollId);
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(@RequestParam() Map<String, String> params) {
        System.out.println("----- EnrollController postInsertAndUpdate() -----");
        System.out.println("Params id : " + params.get("enroll-id"));
        System.out.println("Params code : " + params.get("enroll-student"));
        System.out.println("Params code : " + params.get("enroll-course"));
        return "index";
    }
    
    
    
}
