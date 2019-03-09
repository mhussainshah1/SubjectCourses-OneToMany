package com.example.lesson10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {
        /*Set<Course> courses = new HashSet<>();
        Course course = new Course("Java and Springboots","Melisa A. Fung","you will learn Java SE and EE", 3);
        courses.add(course);
        Subject subject = new Subject("Spring Boot Camp",courses);
        subjectRepository.save(subject);

        courses = new HashSet<>();
        course = new Course("OOP in C++","Dave A. Wolf","C , C++ and OOP",3);
        courses.add(course);
        course = new Course("Data Structure","Rossmie S. Joseph","you will learn Sort Search",3);
        courses.add(course);
        subject = new Subject("Master in IT", courses);
        subjectRepository.save(subject);

        courses = new HashSet<>();
        course = new Course("Kathak dancing","Shristi R. Devi","you will learn folk dancing", 4);
        courses.add(course);
        subject = new Subject("Bachelour in IT", courses);
        subjectRepository.save(subject);*/
    }
}
