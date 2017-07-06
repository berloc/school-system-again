package com.codecool.repository;

import com.codecool.model.PersonalAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonalAssessmentRepository extends JpaRepository<PersonalAssessment, Integer> {

    List<PersonalAssessment>findByStatus(Enum status);


}
