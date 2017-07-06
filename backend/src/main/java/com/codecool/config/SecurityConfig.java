package com.codecool.config;

import com.codecool.model.enums.Role;
import com.codecool.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private PersonRepository repository;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/**", "/registration").permitAll()
                .antMatchers("/api/**").hasRole(Role.MENTOR.toString())
                .and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/")
                ;
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}