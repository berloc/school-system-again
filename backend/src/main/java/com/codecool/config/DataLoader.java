package com.codecool.config;

import com.codecool.model.*;
import com.codecool.model.enums.Place;
import com.codecool.model.enums.Role;
import com.codecool.model.enums.Status;
import com.codecool.model.enums.TypeOfPA;
import com.codecool.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DataLoader {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonalAssessmentRepository personalAssessmentRepository;

    @Autowired
    private PrivateMentoringRepository privateMentoringRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostConstruct
    public void töltsdfellégysziazadatbázist() {

        Mentor mentor = new Mentor();
        Mentor deMentor = new Mentor();
        Student student = new Student();
        Student stuStudent = new Student();
        Student almaStudent = new Student();
        PersonalAssessment personal = new PersonalAssessment();
        PersonalAssessment personal111 = new PersonalAssessment();
        PrivateMentoring privatemen = new PrivateMentoring();
        PrivateMentoring privatemen111 = new PrivateMentoring();
        Group bp1 = new Group();
        Group bp2 = new Group();
        Feedback feedback = new Feedback();


        List<Group> groups = new ArrayList<>();
        groups.add(bp1);
        groups.add(bp2);

        mentor.setFirstName("Tomi");
        mentor.setBirthday(new Date());
        mentor.setGroupList(groups);
        mentor.setRole(Role.MENTOR);
        mentor.setPassword("12345678");
        mentor.setEmail("alma@alma.com");

        deMentor.setFirstName("Dani");
        deMentor.setRole(Role.MENTOR);
//        deMentor.setGroupList(groups);



        List<Student> studentList = new ArrayList<>();

        student.setFirstName("Ádám");
        student.setMentor(deMentor);
        student.setGroup(bp1);
//        System.out.println("student = " + student);

        stuStudent.setFirstName("Béla");
        stuStudent.setMentor(mentor);
        studentList.add(stuStudent);
        student.setGroup(bp1);
//        System.out.println("stuStudent = " + stuStudent);

        almaStudent.setFirstName("Gizi");
        almaStudent.setMentor(mentor);
        studentList.add(almaStudent);
        student.setGroup(bp2);
//        System.out.println("almaStudent = " + almaStudent);

        mentor.setStudentList(studentList);



//        System.out.println("stuStudent's mentor = " + stuStudent.getMentor().getFirstName());
//        System.out.println("student's mentor = " + student.getMentor().getFirstName());
//        System.out.println("deMentor = " + deMentor);
//        System.out.println("mentor = " + mentor);
//        System.out.println("studentList = " + mentor.getStudentList());
//        System.out.println("mentorList = " + mentorList);


        mentorRepository.save(mentor);
        mentorRepository.save(deMentor);
        studentRepository.save(student);
        studentRepository.save(stuStudent);
        studentRepository.save(almaStudent);


        List<Mentor> aaaamentorList = new ArrayList<>();
        aaaamentorList.add(mentorRepository.findOne(mentor.getId()));
        personal111.setStudent(stuStudent);
        personal111.setMentorList(aaaamentorList);
        personal111.setTypeOfPA(TypeOfPA.PYTHONOOP);


        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(mentorRepository.findOne(mentor.getId()));
        mentorList.add(mentorRepository.findOne(deMentor.getId()));

        personal.setMentorList(mentorList);
        personal.setStudent(studentRepository.findOne(almaStudent.getId()));
        personal.setTypeOfPA(TypeOfPA.TECHINTERVIEW);
        personal.setDate(new Date());
        personal.setPlace(Place.GARAGE);
        personal.setStatus(Status.ACTIVE);

        personalAssessmentRepository.save(personal);
        personalAssessmentRepository.save(personal111);

//        System.out.println(personalAssessmentRepository.findAll().get(0).getTypeOfPA());

//        System.out.println(mentorRepository.findByName("Tomi").getName());
        List<Student> students;
//        students = mentorRepository.findByName("Tomi").getStudentList();
//        System.out.println("students = " + students);
//        for (Student stu : students) {
//            System.out.println("stu = " + stu.getName());
//        }

        privatemen.setMentor(mentor);
        privatemen.setStudent(almaStudent);
        privatemen.setTopic("SQL relationships");
        privatemen.setPlace(Place.GARAGE);
        privatemen.setDate(new Date());
        privatemen.setStatus(Status.ACTIVE);
        privateMentoringRepository.save(privatemen);

        privatemen111.setMentor(deMentor);
        privatemen111.setStudent(almaStudent);
        privatemen111.setTopic("OOP");
        privatemen111.setPlace(Place.KITCHENONE);
        privatemen111.setDate(new Date());
        privateMentoringRepository.save(privatemen111);

        bp1.setStudentList(studentList);
        bp1.setMentorList(mentorList);
        bp1.setLocation("Red Room");
        bp1.setName("feláldozhatók");
        groupRepository.save(bp1);

//        bp2.setStudentList(students);
        bp2.setMentorList(aaaamentorList);
        bp2.setLocation("BLue Room");
        bp2.setName("nekik már jobb");
        groupRepository.save(bp2);

        feedback.setFeedback("király?");
        feedback.setFrom(mentor);
        feedback.setTo(almaStudent);
        feedbackRepository.save(feedback);


//        System.out.println(personalAssessmentRepository.findAll());
//        System.out.println(personalAssessmentRepository.findByStatus(Status.ACTIVE));

    }
}
