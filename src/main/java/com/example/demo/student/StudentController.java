package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student){

    }

}
