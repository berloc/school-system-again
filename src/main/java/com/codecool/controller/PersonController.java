package com.codecool.controller;


import com.codecool.dto.StudentDto;
import com.codecool.model.Person;
import com.codecool.model.Student;
import com.codecool.model.enums.Role;
import com.codecool.repository.PersonRepository;
import com.codecool.service.DtoEntityConverter;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DtoEntityConverter dtoEntityConverter;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestBody @Valid StudentDto studentDto) throws JSONException {
        JSONObject response = new JSONObject().put("status", "fail");
        Student student = dtoEntityConverter.convertToEntity(studentDto);
        if (personRepository.findByEmail(student.getEmail()) == null) {
            createStudent(student);
            response.put("status", "success");
        } else {
            response.put("status","email is already in the db");
        }
        return response.toString();
    }


    private void createStudent(Person person) {
        person.setRole(Role.STUDENT);
        person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
        person.setToken(UUID.randomUUID().toString());
        personRepository.save(person);
        logger.info("Save person into the database with {} email", person.getEmail());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    private String validationException(MethodArgumentNotValidException e) throws JSONException {
        logger.info("{} occurred not valid email or password format while tried to save the Student into the db, {} ", e.getCause(), e.getMessage());
        return new JSONObject().put("status", "invalid email or password format").toString();
    }
}



