package com.codecool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Table(name = "Class")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String location;
    private Date startDate;
    private String city;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Student> studentList;

    @ManyToMany(mappedBy = "groupList")
    private List<Mentor> mentorList;

}
