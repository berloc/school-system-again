package com.codecool.repository;

import com.codecool.model.PrivateMentoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateMentoringRepository extends JpaRepository<PrivateMentoring, Integer>{}
