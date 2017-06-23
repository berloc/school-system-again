package com.codecool.model;


import com.codecool.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String name;
    private Date birthday;
    private String birthPlace;
    private String address;
//
    @OneToMany(mappedBy = "to")
    private List<Feedback> givenFeedback;

    @OneToMany(mappedBy = "from")
    private List<Feedback> gotFeedback;

//    public void addFeedback(Person from, Person to, String feedback) {}
}