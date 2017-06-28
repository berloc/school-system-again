package com.codecool.model;


import com.codecool.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String birthPlace;
    private String address;
    private String token;
    private String password;

    @Email
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "to")
    private List<Feedback> givenFeedback;

    @JsonIgnore
    @OneToMany(mappedBy = "from")
    private List<Feedback> gotFeedback;


    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }
}