package com.codecool.controller;

import com.codecool.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


public class PersonControllerTest extends AbstractControllerTest {

    @Autowired
    private PersonRepository personRepository;


    @Before
    public void setup() {
        initMockMvc();
    }

    @Test
    public void findRegisteredPersonTest() throws Exception {

        mockMvc.perform(post("/registration")
                .content("{\"email\":\"user@user.com\", \"password\":\"12345678\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        assertEquals("user@user.com", personRepository.findByEmail("user@user.com").getEmail());
    }
}
