package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.EnrollEntity;
import com.workshop.student.repository.EnrollRepository;

@Service
public class EnrollService {
    
    @Autowired
    private EnrollRepository enrollRepository;

    public List<EnrollEntity> getAllEnroll() {
        return enrollRepository.findAll();
    }

    public EnrollEntity getEnrollById(Integer enrollId) {
        Optional<EnrollEntity> enroll = enrollRepository.findById(enrollId);
        if (enroll.isPresent()) {
            return enroll.get();
        } else {
            return null;
        }
    }

    public EnrollEntity saveEnroll(EnrollEntity enroll) {
        EnrollEntity newEnroll = enrollRepository.save(enroll);
        return newEnroll;
    }

    public void deleteEnroll(Integer enrollId) {
        enrollRepository.deleteById(enrollId);
    }

    
}
