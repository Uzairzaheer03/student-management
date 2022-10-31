package com.studentmanagement.service;

import com.studentmanagement.domain.Student;
import com.studentmanagement.dto.StudentDto;
import com.studentmanagement.repository.StudentRepository;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
       private final StudentRepository studentRepository;


       public StudentService(StudentRepository studentRepository){
              this.studentRepository = studentRepository;
       }

       public String createStudent(StudentDto studentDto){
              Student student = new Student(studentDto.getName(),studentDto.getEmail(),studentDto.getPhone(),studentDto.getCity());
              studentRepository.save(student);
              return " saved student";
       }

       public Optional<Student> getStudent(int id) {

              return studentRepository.findById(id);
       }

       public String updatedStudent(int id, StudentDto studentDto) {

              Optional<Student> student= getStudent(id);
              studentDto.getName();
              studentDto.getEmail();
              studentDto.getPhone();
              studentDto.getCity();
              studentRepository.save(student.get());
              return " update student ";
       }


       public String deleteStudent(int id) {
              studentRepository.deleteById(id);
              return " delete student";
       }

       public List<Student> getAllStudent() {
              List<Student> students = new ArrayList<Student>();
              studentRepository.findAll().forEach(student -> students.add(student));;
              return students;

       }


       public  Page<Student> getAllStudent(Integer pageNumber, Integer pageSize) {

              Pageable pageable = PageRequest.of(pageNumber, pageSize);
              Page<Student> pageStudent = this.studentRepository.findAll(pageable);
              List<Student> students = pageStudent.getContent();


              return pageStudent;
       }



}
