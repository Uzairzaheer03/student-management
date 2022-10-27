package com.studentmanagement.controller;

import com.studentmanagement.domain.Student;
import com.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



@RestController
public class StudentController{
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return Arrays.asList(
                new Student("name", "email", "phone", "city"),
                new Student("usama", "usama@gmail.com", "0300", "lahore"),
                new Student("saif", "saif@gmail.com", "0302", "islamabad")
        );
    }
    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String city){
        return studentService.createStudent(name,email,phone,city);
    }

    @GetMapping("/getByStudentId")
    public Optional<Student> getStudentById(@RequestParam int id){
        return studentService.getStudent(id);
    }

    @PutMapping("/update")
    public String update(@RequestParam int id,@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String city ){
        return studentService.updatedStudent(id,name,email,phone,city);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){

        return studentService.getAllStudent();
    }

    @GetMapping("/studentByPage")
    public Page<Student> getAllStudent(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value= "pageSize", defaultValue  = "3", required = false) Integer pageSize
    ){

        return studentService.getAllStudent(pageNumber, pageSize);
    }

}
