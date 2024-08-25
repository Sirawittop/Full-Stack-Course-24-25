package com.workshop.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.student.entity.EnrollEntity;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer> {
    
}
