package com.codecool.controller;


import com.codecool.abstracttest.AbstractTest;
import com.codecool.model.Person;
import com.codecool.repository.PersonRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.annotation.Resource;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public abstract class AbstractControllerTest extends AbstractTest{

    String host = "http://localhost";
    String registration = host + "/registration";
    String login = host + "/login";

    @Resource
    FilterChainProxy springSecurityFilterChain;

    @Resource
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    Person mockUser = new Person("user@user.com", "password");

    @Autowired
    PersonRepository personRepository;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .addFilters(springSecurityFilterChain)
                .build();
    }
}

