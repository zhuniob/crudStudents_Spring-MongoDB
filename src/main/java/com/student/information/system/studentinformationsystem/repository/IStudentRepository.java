package com.student.information.system.studentinformationsystem.repository;

import com.student.information.system.studentinformationsystem.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IStudentRepository extends MongoRepository<Student, String> {

    Student findBynStudent(long nStudent);
    Student findByEmail (String email);
    List<Student> findByOrderByGpa();

}