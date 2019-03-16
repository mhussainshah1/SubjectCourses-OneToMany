package com.example.lesson10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("course", new Course());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "courseform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Course course,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("subjects", subjectRepository.findAll());
            return "courseform";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @GetMapping("/addsubject")
    public String subjectForm(Model model){
        model.addAttribute("subject", new Subject());
        return "subject";
    }

    @PostMapping("/processsubject")
    public String processSubject(@Valid Subject subject, BindingResult result,
                                 Model model){
        if(result.hasErrors()){
            return "subject";
        }
        if(subjectRepository.findByTitle(subject.getTitle()) != null){
            model.addAttribute("message", "You already have a subject called " +
                    subject.getTitle() + "!" + " Try something else.");
            return "subject";
        }
        subjectRepository.save(subject);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("subjects", subjectRepository.findAll());
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courseform";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        courseRepository.deleteById(id);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables(){
        /*Set<Course> courses = new HashSet<>();
        Course course = new Course("Java and Springboots","Melisa A. Fung","you will learn Java SE and EE", 3,);
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









