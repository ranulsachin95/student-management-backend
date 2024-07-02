package com.assignment.student_management.service;


import com.assignment.student_management.entity.Enrollment;
import com.assignment.student_management.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollment(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Enrollment existingEnrollment = getEnrollment(id);
//        existingEnrollment.setStudent(enrollment.getStudent());
//        existingEnrollment.setCourse(enrollment.getCourse());
        return enrollmentRepository.save(existingEnrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}