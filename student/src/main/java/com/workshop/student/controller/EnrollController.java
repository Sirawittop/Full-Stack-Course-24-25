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

import com.workshop.student.entity.EnrollEntity;
import com.workshop.student.entity.StudentEntity;
import com.workshop.student.entity.courseEntity;
import com.workshop.student.service.CourseService;
import com.workshop.student.service.EnrollService;
import com.workshop.student.service.StudentService;



@Controller
@RequestMapping("/enroll")
public class EnrollController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollService enrollService;

    @GetMapping({"", "/"})
    public String getAll() {
        System.out.println("----- EnrollController getAll() -----");

        List<EnrollEntity> enrollList = enrollService.getAllEnroll();
        System.out.println("----- EnrollController getAll Enroll -----");
        System.out.println("Size: " + enrollList.size());


        return "index";
    }

    @GetMapping("/{enroll-id}")
    public String getById(
        @PathVariable(name = "enroll-id", required = true) Integer enrollId) {
        System.out.println("----- EnrollController getById() -----");
        System.out.println("Enroll ID: " + enrollId);

        EnrollEntity enroll = enrollService.getEnrollById(enrollId);
        System.out.println("----- EnrollController getById Enroll -----");
        System.out.println("Enroll Name: " + enroll.getCourse().getCourseName());
        System.out.println("Enroll First Name: " + enroll.getStudent().getStudentFirstName());
        System.out.println("Enroll Last Name: " + enroll.getStudent().getStudentLastName());

        return "index";
    }
    
    @GetMapping("/delete/{enroll-id}")
    public String getDeleteById(
        @PathVariable(name = "enroll-id", required = true) Integer enrollId) {
        System.out.println("----- EnrollController getDeleteById() -----");
        System.out.println("Enroll ID: " + enrollId);
        
        System.out.println("----- EnrollController getDeleteById Enroll -----");
        EnrollEntity enroll = enrollService.getEnrollById(enrollId);
        System.out.println("Enroll Name: " + enroll.getCourse().getCourseName());

        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(@RequestParam() Map<String, String> params) {
        System.out.println("----- EnrollController postInsertAndUpdate() -----");
        System.out.println("Params id : " + params.get("enroll-id"));
        System.out.println("Params code : " + params.get("enroll-student"));
        System.out.println("Params code : " + params.get("enroll-course"));



        System.out.println("----- EnrollController postInsertAndUpdate Enroll -----");
        Integer courseId = Integer.parseInt(params.get("course-id"));       
        courseEntity courseEntity = courseService.getCourseById(courseId);
        System.out.println("Course ID :" + courseEntity.getCourseId());

        Integer studentId = Integer.parseInt(params.get("student-id"));
        StudentEntity studentEntity = studentService.getStudentById(studentId);
        System.out.println("Student ID :" + studentEntity.getStudentId());
        

        EnrollEntity enroll = new EnrollEntity();
        if (null != params.get("enroll-id")) {
            enroll.setEnrollId(Integer.parseInt(params.get("enroll-id")));
        }
        enroll.setCourse(courseEntity);
        enroll.setStudent(studentEntity);
        EnrollEntity result = enrollService.saveEnroll(enroll);
        System.out.println("Enroll ID: " + result.getEnrollId());
        System.out.println("Enroll Course: " + result.getCourse().getCourseName());

        return "index";
    }
    
    
    
}
