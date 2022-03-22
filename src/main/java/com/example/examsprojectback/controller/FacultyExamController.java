package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.FacultyExam;
import com.example.examsprojectback.service.FacultyExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class FacultyExamController {
    @Autowired
    private FacultyExamService facultyExamService;

    @GetMapping("/examsfaculty/")
    public ArrayList<FacultyExam> getAllFacultyExam() {
        return facultyExamService.getAllFacultyExams();
    }

    @GetMapping("/examsfaculty/{id}")
    public  ArrayList<FacultyExam> getFacultyExamByApplicantId(@PathVariable int id){
        return facultyExamService.getFacultyExamByApplicantId(id);
    }

    @GetMapping("/examsfaculty/notPassed/{id}")
    public ArrayList<FacultyExam> getNotPassedFacultyExam(@PathVariable int id) {
        return facultyExamService.getNotPassedExams(id);
    }

    @GetMapping("/examfaculty/{id}")
    public  FacultyExam getFacultyExamById(@PathVariable int id){
        return facultyExamService.getFacultyExamById(id);
    }
}
