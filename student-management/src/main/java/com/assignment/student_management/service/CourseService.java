package com.assignment.student_management.service;


import com.assignment.student_management.entity.Course;
import com.assignment.student_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourse(id);
//        existingCourse.setTitle(course.getTitle());
//        existingCourse.setDescription(course.getDescription());
//        existingCourse.setDuration(course.getDuration());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}