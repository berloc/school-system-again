package com.codecool.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Mentor extends Person {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "mentor", fetch = FetchType.EAGER)
    private List<Student> studentList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mentor_group",
            joinColumns = @JoinColumn(name = "mentor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"mentor_id", "group_id"}))
    private List<Group> groupList;

    @OneToMany(mappedBy = "mentor")
    private List<PrivateMentoring> privateMentoringList;

    @ManyToMany(mappedBy = "mentorList")
    private List<PersonalAssessment> personalAssessmentList;



}