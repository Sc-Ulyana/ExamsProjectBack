package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Faculty;
import com.example.examsprojectback.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties")
    public ArrayList<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }
}
