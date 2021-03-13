package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping()
    public void createStudent(@RequestBody Student student) {
        service.createStudent(student);
    }

    @PutMapping()
    public void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
    }

}
