package com.ajil.springboot3demo.service;

import com.ajil.springboot3demo.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> studentList = new ArrayList<>();
    @Autowired
    private ObservationRegistry observationRegistry;

    public Student addStudent(Student student) {
        studentList.add(student);
        //return student;
        return Observation.createNotStarted("addStudent",observationRegistry).observe(()-> student);
    }

    public List<Student> getAllStudent() {
       // return studentList;
        return Observation.createNotStarted("getStudent",observationRegistry).observe(()-> studentList);

    }

    public Student getStudent(String id) {
//        return studentList.stream()
//                .filter(student -> student.id().equals(id) )
//                .findFirst().orElseThrow(()-> new RuntimeException("student is not available") );
       return Observation.createNotStarted("getStudentId",observationRegistry).observe(()->  studentList.stream()
               .filter(student -> student.id().equals(id) )
               .findFirst().orElseThrow(()-> new RuntimeException("student is not available") ));

    }
}
