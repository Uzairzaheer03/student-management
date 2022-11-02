package com.studentmanagement.service;

import com.studentmanagement.domain.Student;
import com.studentmanagement.dto.StudentDto;
import com.studentmanagement.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
       private final StudentRepository studentRepository;


       public StudentService(StudentRepository studentRepository){
              this.studentRepository = studentRepository;
       }

       public String createStudent(StudentDto studentDto){
              Student student = new Student(studentDto.getName(),studentDto.getEmail(),studentDto.getPhone(),studentDto.getCity());
              studentRepository.save(student);
              log.info("saved student {}",student);
              return " saved student";
       }

       public Optional<Student> getStudent(int id) {
              log.info("find by Id {}",id);
              return studentRepository.findById(id);
       }

       public String updatedStudent(int id, StudentDto studentDto ) {

              Optional<Student> optionalStudent= getStudent(id);
              if(optionalStudent.isPresent()){
                     optionalStudent.get().setName(studentDto.getName());
                     optionalStudent.get().setEmail(studentDto.getEmail());
                     optionalStudent.get().setPhone(studentDto.getPhone());
                     optionalStudent.get().setCity(studentDto.getCity());
                     studentRepository.save(optionalStudent.get());
                     log.info("update studentDto {} id {}",studentDto, id);
                     return " update student ";
              }else{
                     return "student not exist with id:"+id;
              }
       }


       public String deleteStudent(int id) {
              studentRepository.deleteById(id);
              log.info("delete student {}",id);
              return " delete student";
       }

       public List<Student> getAllStudent() {
              log.info("find all {}");
              return new ArrayList<>(studentRepository.findAll());
       }


       public  Page<Student> getAllStudent(Integer pageNumber, Integer pageSize) {

              Pageable pageable = PageRequest.of(pageNumber, pageSize);
              log.info("find all pageable {}",pageable);
              return this.studentRepository.findAll(pageable);
       }


       public List<Student> getStudentByCity(String city) {
              log.info("find by city {}",city);
              return studentRepository.findByCity(city);
       }
}
