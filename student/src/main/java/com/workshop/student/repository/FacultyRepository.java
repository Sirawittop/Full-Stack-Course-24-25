package com.workshop.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.student.entity.FacultyEntity;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, Integer> {
    
}
