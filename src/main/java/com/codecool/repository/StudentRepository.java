package com.codecool.repository;

import com.codecool.model.Group;
import com.codecool.model.Mentor;
import com.codecool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findStudentByMentor(Mentor mentor);

    Student findById(Integer id);

    List<Student> findByGroup(Group group);
}
