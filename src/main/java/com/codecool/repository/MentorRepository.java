package com.codecool.repository;


import com.codecool.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer>{

    Mentor findById(Integer id);

    Mentor findByName(String name);

}
