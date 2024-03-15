package com.example.studentapp.doa;

import com.example.studentapp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer> {

    Subject findSubjectBySubName(String sunName);
}
