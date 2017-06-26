package com.codecool.model;


import com.codecool.model.enums.Status;
import com.codecool.model.enums.TypeOfPA;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PersonalAssessment extends DateWithMentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeOfPA typeOfPA;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "mentor_personal_assessment",
            joinColumns = @JoinColumn(name = "personal_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"personal_id","mentor_id"}))
    private List<Mentor> mentorList;
}
