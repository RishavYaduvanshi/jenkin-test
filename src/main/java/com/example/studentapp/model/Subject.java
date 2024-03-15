package com.example.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;
    private int subCode;
    private String subName;
    private String teacherName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "subjects")
    @JsonIgnore
    private  Set<Student> students;

}
