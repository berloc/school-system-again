package com.codecool.controller;


import com.codecool.model.Person;
import com.codecool.model.Student;
import com.codecool.model.enums.Role;
import com.codecool.repository.PersonRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private PersonRepository personRepository;


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestBody String data) throws JSONException {
        JSONObject response = new JSONObject().put("status", "fail");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            JSONObject rawData = new JSONObject(data);
            if (rawData.get("email").toString().contains("@") && rawData.get("password").toString().length()>= 8) {
                Student person = mapper.readValue(data, Student.class);
                if (personRepository.findByEmail(person.getEmail())==null) {
                    createStudent(person, rawData);
                    response.put("status", "success");
                } else {
                    response.put("status", "email already exist in db");
                    logger.info("This email already exist in the database");
                }
            } else {
                response.put("status","Not valid email format or too short password");
                logger.info("Not valid email format or too short password");
            }
        }
        catch (IOException | JSONException e) {
            logger.error("{} occurred while creating the person: {}", e.getCause(), e.getMessage());
        }
        return response.toString();
    }


    private void createStudent(Person person, JSONObject data) {
        person.setRole(Role.STUDENT);
        person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
        person.setToken(UUID.randomUUID().toString());
        personRepository.save(person);
        logger.info("Save person into the database with {} email", person.getEmail());
    }
}



