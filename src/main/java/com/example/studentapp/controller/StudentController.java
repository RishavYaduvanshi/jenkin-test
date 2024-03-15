package com.example.studentapp.controller;

import com.example.studentapp.dto.StudentDto;
import com.example.studentapp.model.Student;
import com.example.studentapp.model.Subject;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @GetMapping("test")
    public String testing(){
        return "Hello Jenkins";
    }

    @PostMapping("add")
    public Student addStudent(@RequestBody StudentDto studentDto){

        Student student = new Student();
        Set<Subject> stSub = new HashSet<>();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentID(studentDto.getStudentID());
        student.setRollNo(studentDto.getRollNo());
        for(String i:studentDto.getSubName()) {
            stSub.add(subjectService.getSubjectBySubjectName(i));
        }
        student.setSubjects(stSub);

        studentService.addStudent(student);
        return student;
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("subject")
    public List<Student> getStudentBySubjectName(@RequestParam String subName){
        Subject sub = subjectService.getSubjectBySubjectName(subName);
        return studentService.getStudentsBySubject(sub);
    }

    @GetMapping("subjects")
    public List<Student> getStudentBySubjectName(@RequestParam(value = "subName") List<String> subName){
        List<Subject> ls = new ArrayList<>();
        for(String sub:subName){
            ls.add(subjectService.getSubjectBySubjectName(sub));
        }
        return studentService.getStudentsBySubjects(ls);

    }


    @GetMapping("student/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
}
