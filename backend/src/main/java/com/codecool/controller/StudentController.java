package com.codecool.controller;


import com.codecool.repository.PersonalAssessmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    private PersonalAssessmentRepository personalAssessmentRepository;




}
