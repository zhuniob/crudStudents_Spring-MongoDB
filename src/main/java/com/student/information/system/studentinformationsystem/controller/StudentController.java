package com.student.information.system.studentinformationsystem.controller;

import com.student.information.system.studentinformationsystem.model.Student;
import com.student.information.system.studentinformationsystem.service.IStudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping(value = "/listbynumberstudent/{nStudent}")
    public Student findStudentByNumber (@PathVariable ("student") Long nStudent ){
        return studentService.findBynStudent(nStudent);
    }

    @GetMapping(value = "getbyemail/{email}")
    public Student getByEmail (String email){
        return studentService.findByEmail(email);
    }

    @GetMapping(value = "/orderbygpa/{gpa}")
    public List<Student> findAllByOrderByGpaDesc(){
        return studentService.findByOrderByGpa();
    }
    @PostMapping(value = "/saveorupdate")
    public ResponseEntity<?> SaveOrUpdateStudent(@RequestBody Student student){
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Registro guardado con exito", HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{nStudent}")
    public void DeleteStudent (@PathVariable Long nStudent){
        studentService.deleteStudent(studentService.findBynStudent(nStudent).getId());
    }

}