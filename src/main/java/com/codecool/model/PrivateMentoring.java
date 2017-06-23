package com.codecool.model;


import com.codecool.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter

public class PrivateMentoring extends DateWithMentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String topic;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
}
