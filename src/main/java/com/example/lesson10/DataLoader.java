package com.example.lesson10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
//        //Set<Course> courses = new HashSet<>();
//        Course course = new Course("Java and Springboots","Melisa A. Fung","you will learn Java SE and EE", 3);
        Subject subject = new Subject("Spring Boot Camp");
//        subject.getCourses().add(course);
//        courseRepository.save(course);
        subjectRepository.save(subject);
//
//
////        courses = new HashSet<>();
//        course = new Course("OOP in C++","Dave A. Wolf","C , C++ and OOP",3);
//        courses.add(course);
//        course = new Course("Data Structure","Rossmie S. Joseph","you will learn Sort Search",3);
//        courses.add(course);
        subject = new Subject("Master in IT");
//        courseRepository.save(course);
        subjectRepository.save(subject);
//
////        courses = new HashSet<>();
//        course = new Course("Kathak dancing","Shristi R. Devi","you will learn folk dancing", 4);
        subject = new Subject("Bachelour in IT");
//        subject.getCourses().add(course);
//        courseRepository.save(course);
        subjectRepository.save(subject);
    }
}
