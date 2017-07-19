package com.codecool.service;


import com.codecool.dto.PersonDto;
import com.codecool.model.Mentor;
import com.codecool.model.Person;
import com.codecool.model.Student;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoEntityConvert/er {

    private static final Logger logger = LoggerFactory.getLogger(DtoEntityConverter.class);


    @Autowired
    private ModelMapper modelMapper;


    public Person convertToEntity(String type, PersonDto dto) {
        switch (type) {
            case "mentor":
                logger.debug("Dt");
                return new Mentor(dto.getEmail(), dto.getFirstName(), dto.getLastName());
            case "student":
                return new Student(dto.getEmail(), dto.getPassword());
            }
        return null;
    }

//    public Person convertToEntity(PersonDto dto) {
//        return new Student(dto.getEmail(), dto.getPassword());
//    }
//
//    public Mentor convertToEntity(MentorDto dto) {
//        return new Mentor(dto.getEmail(), dto.getFirstName(), dto.getLastName());
//    }
}
