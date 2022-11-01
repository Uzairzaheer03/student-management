package com.studentmanagement.repository;

import com.studentmanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    List<Student> findByCity(String city);
}
