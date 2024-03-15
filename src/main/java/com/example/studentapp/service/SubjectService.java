package com.example.studentapp.service;

import com.example.studentapp.doa.SubjectRepo;
import com.example.studentapp.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    SubjectRepo subjectRepo;
    public Subject addSubject(Subject subject){
        return subjectRepo.save(subject);

    }

    public Subject getSubjectBySubjectName(String subName){
        return subjectRepo.findSubjectBySubName(subName);
    }


}
