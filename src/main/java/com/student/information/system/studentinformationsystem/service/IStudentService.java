package com.student.information.system.studentinformationsystem.service;

import com.student.information.system.studentinformationsystem.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findBynStudent(long nStudent);
    public Student findByEmail (String email);
    public List<Student> findByOrderByGpa();
    public void saveOrUpdateStudent (Student student);
    public void deleteStudent (String id);
}
