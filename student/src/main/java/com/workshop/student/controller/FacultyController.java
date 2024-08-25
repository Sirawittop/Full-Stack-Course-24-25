package com.workshop.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping({ "", "/" })
    public String getAll(ModelMap model) {
        System.out.println("----- getAll -----");

        List<FacultyEntity> facultyList = facultyService.getAllFaculty();
        System.out.println("----- getAll Faculty -----");
        System.out.println("Size: " + facultyList.size());
        model.addAttribute("faculties", facultyList);

        return "faculty/index.html";
    }

    @GetMapping("/{faculty-id}")
    public String getById(
            @PathVariable(name = "faculty-id", required = true) Integer facultyId, ModelMap model) {
        System.out.println("----- getById -----");
        System.out.println("Faculty ID: " + facultyId);

        FacultyEntity faculty = facultyService.getFacultyById(facultyId);
        System.out.println("----- getById Faculty -----");

        model.addAttribute("faculty", faculty);

        List<FacultyEntity> facultyList = facultyService.getAllFaculty();
        model.addAttribute("faculties", facultyList);

        return "faculty/index.html";
    }

    @PostMapping("/")
    public String postInsertAadUpdate(
            @RequestParam() Map<String, String> params, ModelMap model) {
        System.out.println("----- postInsertAadUpdate -----");
        System.out.println("Params id : " + params.get("faculty-id"));
        System.out.println("Params code : " + params.get("faculty-name"));

        System.out.println("----- postInsertAadUpdate Faculty -----");
        FacultyEntity faculty = new FacultyEntity();
        if (null != params.get("faculty-id") && !params.get("faculty-id").isEmpty()) {
            faculty.setFacultyId(Integer.parseInt(params.get("faculty-id")));
        }

        faculty.setFacultyName(params.get("faculty-name"));
        FacultyEntity result = facultyService.saveFaculty(faculty);
        System.out.println("Faculty ID: " + result.getFacultyId());
        System.out.println("Faculty Name: " + result.getFacultyName());

        List<FacultyEntity> facultyList = facultyService.getAllFaculty();
        model.addAttribute("faculties", facultyList);

        return "faculty/index.html";
    }

    @GetMapping("/delete/{faculty-id}")
    public String getDeleteById(
            @PathVariable(name = "faculty-id", required = true) Integer facultyId, ModelMap model) {
        System.out.println("----- getDeleteById -----");
        System.out.println("Faculty ID: " + facultyId);

        System.out.println("----- getDeleteById Faculty -----");
        facultyService.deleteFaculty(facultyId);

        List<FacultyEntity> facultyList = facultyService.getAllFaculty();
        model.addAttribute("faculties", facultyList);

        return "faculty/index.html";
    }
}
