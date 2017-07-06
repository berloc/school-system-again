package com.codecool.controller;


import com.codecool.model.Student;
import com.codecool.repository.MentorRepository;
import com.codecool.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MentorController {

    private static final Logger logger = LoggerFactory.getLogger(MentorController.class);

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

//    @PreAuthorize("hasRole('ROLE.MENTOR')")
    @RequestMapping(value = "/getstudents/{mentor}", method = RequestMethod.GET)
    public List<Student> getStudentsByMentor(@PathVariable(value = "mentor") String mentor) {
        return studentRepository.findStudentByMentor(mentorRepository.findByFirstName(mentor));
    }


}
