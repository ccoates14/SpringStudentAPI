package com.example.demo.student;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repo ;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public void createStudent(Student s){
        boolean success = false;
        if (s.getEmail() == null) throw new RuntimeException("Email was null");

        try{
            if (repo.findStudentByEmail(s.getEmail()).isEmpty()){
                repo.save(s);
                success = true;
            }

        } catch(Exception e){
            System.out.println(e);
        }finally{
            if (!success){
                throw new RuntimeException();
            }
        }

    }

    public void updateStudent(Student s){
        if (s.getId() == null || repo.findById(s.getId()).isEmpty()){
            throw new RuntimeException("Could not find user");
        }

        Student studentFromDB = repo.findById(s.getId()).get();

        if (s.getEmail() != null && !studentFromDB.getEmail().equals(s.getEmail())){
            if (repo.findStudentByEmail(s.getEmail()).isEmpty()){
                studentFromDB.setEmail(s.getEmail());
            }
        }
        if (s.getDob() != null){
            studentFromDB.setDob(s.getDob());
        }
        if (s.getName() != null){
            studentFromDB.setName(s.getName());
        }

        repo.save(studentFromDB);
    }

    public void deleteStudent(Long id){
        boolean success = false;
        try{

            if (repo.findById(id).isPresent()) {
                repo.deleteById(id);
                success = true;
            }

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            if (!success) throw new RuntimeException("User was not found or an internal error occurred");
        }
    }
}
