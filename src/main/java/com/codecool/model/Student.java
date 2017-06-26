package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<PrivateMentoring> privateMentoringList;

    @OneToMany(mappedBy = "student")
    private List<PersonalAssessment> personalAssessmentList;

}
