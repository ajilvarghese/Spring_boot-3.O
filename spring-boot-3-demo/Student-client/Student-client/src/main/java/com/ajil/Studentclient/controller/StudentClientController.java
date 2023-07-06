package com.ajil.Studentclient.controller;

import com.ajil.Studentclient.model.Student;
import com.ajil.Studentclient.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/students")
public class StudentClientController {
    @Autowired
    private StudentClientService studentClientService;
    @GetMapping
    List<Student> getAllStudents(){
        return studentClientService.getAllStudent();

    }
}
