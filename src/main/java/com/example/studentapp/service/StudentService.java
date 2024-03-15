package com.example.studentapp.service;

import com.example.studentapp.doa.StudentRepo;
import com.example.studentapp.model.Student;
import com.example.studentapp.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public void addStudent(Student student){
        studentRepo.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
    public Optional<Student> getStudentById(int id){
        return studentRepo.findById(id);
    }

    public List<Student> getStudentsBySubject(Subject subject){
        return studentRepo.findStudentsBySubject(subject);
    }

    public List<Student> getStudentsBySubjects(Collection<Subject>subjects){
        return studentRepo.findStudentsBySubjects(subjects);
    }

}
