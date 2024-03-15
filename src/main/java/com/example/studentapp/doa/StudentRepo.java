package com.example.studentapp.doa;

import com.example.studentapp.model.Student;
import com.example.studentapp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query("SELECT s FROM Student s WHERE :subject IN elements(s.subjects)")
    List<Student> findStudentsBySubject(@Param("subject") Subject subject);



    @Query("SELECT DISTINCT s FROM Student s JOIN s.subjects sub WHERE sub IN :subjects")
    List<Student> findStudentsBySubjects(@Param("subjects") Collection<Subject> subjects);
}
