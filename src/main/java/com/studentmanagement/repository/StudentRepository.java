package com.studentmanagement.repository;

import com.studentmanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    Optional<Student> findByCity(String city);
}
