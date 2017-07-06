package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "from_id")
    private Person from;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to_id")
    private Person to;

    @Column(columnDefinition = "TEXT")
    private String feedback;

}
