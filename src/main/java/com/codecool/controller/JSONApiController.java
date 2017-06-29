package com.codecool.controller;

import com.codecool.model.Mentor;
import com.codecool.model.PersonalAssessment;
import com.codecool.model.Student;
import com.codecool.model.enums.Place;
import com.codecool.model.enums.Status;
import com.codecool.model.enums.TypeOfPA;
import com.codecool.repository.GroupRepository;
import com.codecool.repository.MentorRepository;
import com.codecool.repository.PersonalAssessmentRepository;
import com.codecool.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class JSONApiController {

    private static final Logger logger = LoggerFactory.getLogger(JSONApiController.class);


    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PersonalAssessmentRepository personalAssessmentRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public Place[] getPlace() {
        logger.debug("/place route called, collect the places");
        return Place.values();
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public TypeOfPA[] getType() {
        logger.debug("/type route called, collect the type of PA-s");
        return TypeOfPA.values();
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Status[] getStatus() {
        logger.debug("/status route called, collect the status of PA/PM-s");
        return Status.values();
    }

    @RequestMapping(value = "students/{group}", method = RequestMethod.GET)
    public List<Student> getStudentsByGroup(@PathVariable(value = "group")String id) {
        List<Student> result;
        if (id.equals("all")) {
            logger.debug("/students/{} route called, collect all students", id);
            result = studentRepository.findAll();
        }
        else {
            logger.debug("/students/{} route called, collect the students", id);
            result = studentRepository.findByGroup(groupRepository.findById(Integer.parseInt(id)));
        }
        return result;
    }

    @RequestMapping(value = "/getmentors", method = RequestMethod.GET)
    public List<Mentor> getMentor() {
        logger.debug("/getmentors route called, collect the mentors");
        return mentorRepository.findAll();
    }

    @RequestMapping(value = "/getpa/{status}", method = RequestMethod.GET)
    public List<PersonalAssessment> getStudentsPa(@PathVariable(value = "status") String status) {
        List<PersonalAssessment> result;
        switch (status) {
            case "all":
                result = personalAssessmentRepository.findAll();
                logger.debug("/getpa route called, collect the pa-s with status: {}", status);
                break;
            case "active":
                result = personalAssessmentRepository.findByStatus(Status.ACTIVE);
                logger.debug("/getpa route called, collect the pa-s with status: {}", status);
                break;
            case "past":
                result = personalAssessmentRepository.findByStatus(Status.PAST);
                logger.debug("/getpa route called, collect the pa-s with status: {}", status);
                break;
            default:
                result = personalAssessmentRepository.findAll();
        }
        return result;
    }
}
