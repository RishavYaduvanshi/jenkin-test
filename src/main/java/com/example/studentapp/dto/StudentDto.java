package com.example.studentapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private int studentID;
    private String studentName;
    private String rollNo;
    private Set<String> subName;
}
