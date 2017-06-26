package com.codecool.model;


import com.codecool.model.enums.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class DateWithMentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-DD hh:mm")
    private Date date;
    private Place place;

}
