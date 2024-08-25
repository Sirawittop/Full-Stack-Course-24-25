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

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.entity.StudentEntity;
import com.workshop.student.service.FacultyService;
import com.workshop.student.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;
    
    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- StudentController getAll() -----");

        List<StudentEntity> studentList = studentService.getAllStudent();
        System.out.println("----- StudentController getAll Student -----");
        System.out.println("Size: " + studentList.size());

        return "student/index.html";
    }

    @GetMapping("/{student-id}")
    public String getById(
        @PathVariable(name = "student-id", required = true) Integer studentId) {
        System.out.println("----- StudentController getById() -----");
        System.out.println("Student ID: " + studentId);

        StudentEntity student = studentService.getStudentById(studentId);
        System.out.println("----- StudentController getById Student -----");
        System.out.println("Student Name: " + student.getStudentFirstName() + " " + student.getStudentLastName());


        return "student/index.html";
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

        System.out.println("----- StudentController postInsertAndUpdate Student -----");
        Integer facultyId = Integer.parseInt(params.get("faculty-id"));
        FacultyEntity facultyEntity = facultyService.getFacultyById(facultyId);
        System.out.println(facultyEntity.getFacultyId());

        StudentEntity student = new StudentEntity();
        if (null != params.get("student-id")) {
            student.setStudentId(Integer.parseInt(params.get("student-id")));
        }
        student.setStudentCode(params.get("student-code"));
        student.setStudentFirstName(params.get("student-firstname"));
        student.setStudentLastName(params.get("student-lastname"));
        student.setFaculty(facultyEntity);
        StudentEntity result = studentService.saveStudent(student);
        System.out.println("Student ID: " + result.getStudentId());
        System.out.println("Student Code: " + result.getStudentCode());
        System.out.println("Student First Name: " + result.getStudentFirstName());
        System.out.println("Student Last Name: " + result.getStudentLastName());
        System.out.println("Student Faculty: " + result.getFaculty().getFacultyName());
        return "student/index.html";
    }
    

    @GetMapping("/delete/{student-id}")
    public String getDeleteById(
        @PathVariable(name = "student-id", required = true) Integer studentId) {
        System.out.println("----- StudentController getDeleteById() -----");
        System.out.println("Student ID: " + studentId);

        System.out.println("----- StudentController getDeleteById Student -----");
        studentService.deleteStudent(studentId);
        return "student/index.html";
    }
    
}
