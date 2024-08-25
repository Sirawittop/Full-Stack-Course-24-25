package com.workshop.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshop.student.entity.courseEntity;

@Repository
public interface CourseRepository extends JpaRepository<courseEntity, Integer> {

}
