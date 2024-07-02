package com.assignment.student_management.service;

import com.assignment.student_management.entity.Student;
import com.assignment.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudent(id);
//        existingStudent.setName(student.getName());
//        existingStudent.setEmail(student.getEmail());
//        existingStudent.setDateOfBirth(student.getDateOfBirth());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}