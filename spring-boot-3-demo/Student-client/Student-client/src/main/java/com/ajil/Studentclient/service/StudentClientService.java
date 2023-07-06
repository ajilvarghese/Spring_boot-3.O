package com.ajil.Studentclient.service;

import com.ajil.Studentclient.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/students")
public interface StudentClientService {
    @GetExchange
    List<Student> getAllStudent();
}
