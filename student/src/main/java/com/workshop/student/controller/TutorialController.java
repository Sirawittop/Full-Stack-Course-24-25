package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TutorialController {

    @GetMapping("/")
    public String getTutorial(
            @RequestParam(name = "id", required = false, defaultValue = "0") Integer id) {
        System.out.println("----- getTutorial -----");
        System.out.println("ID: " + id);
        return "index";
    }

    @GetMapping("/{id}")
    public String getTutorialPath(
            @PathVariable("id") Integer id) {
        System.out.println("----- getTutorialPath -----");
        System.out.println("ID: " + id);
        return "index";
    }

    @PostMapping("/")
    public String postTutorial(
        @RequestParam() Map<String, String> params) {
        System.out.println("----- postTutorial -----");
        System.out.println("Params: " + params.get("id"));
        System.out.println("Params: " + params.get("code"));
        return "index";
        }

}
