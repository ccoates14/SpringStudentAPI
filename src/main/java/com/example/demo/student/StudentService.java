package com.example.demo.student;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository repo ;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

}
