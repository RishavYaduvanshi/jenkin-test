package com.example.studentapp.controller;

import com.example.studentapp.model.Subject;
import com.example.studentapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @PostMapping("add")
    public  Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }
}
