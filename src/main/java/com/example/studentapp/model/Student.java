package com.example.studentapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stId;
    private int studentID;
    private String studentName;
    private String rollNo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "student_subject", // Name of the join table
            joinColumns = @JoinColumn(name = "st_id"), // Foreign key column in the join table for Student
            inverseJoinColumns = @JoinColumn(name = "sub_id") // Foreign key column in the join table for Subject
    )

    private Collection<Subject> subjects;

}
