package com.studentmanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class StudentDto {

    private String name;
    private String email;
    private String phone;
    private String city;


    public StudentDto(String name, String email, String phone, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }
    public StudentDto() {

    }
    
}
