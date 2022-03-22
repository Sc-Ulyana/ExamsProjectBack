package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Applicant;
import com.example.examsprojectback.service.ApplicantService;
import com.example.examsprojectback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private UserService userService;

    @GetMapping("/applicants/")
    public ArrayList<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/applicants/top/{facultyId}")
    public ArrayList<Applicant> getTopApplicants(@PathVariable int facultyId) {
        return applicantService.getTopApplicantsByFacultyId(facultyId);
    }

    @GetMapping("/applicants/{id}")
    public int getApplicantId(@PathVariable int id) {
        return applicantService.getUserIdByApplicantId(id);
    }

    @GetMapping("/applicant/{applicantId}")
    public Applicant getApplicantById(@PathVariable int applicantId) {
        return applicantService.getApplicant(applicantId);
    }

    @GetMapping("/applicants/all/{facultyId}")
    public ArrayList<Applicant> getApplicantsByFacultyId(@PathVariable int facultyId) {
        return applicantService.getApplicantsByFacultyId(facultyId);
    }

    @PostMapping("/applicants")
    public void addApplicant(@RequestBody Applicant applicant) {
        applicantService.addApplicant(applicant);
    }

    @PutMapping("/applicants/")
    public void updateApplicant(@RequestBody Applicant applicant) {
        userService.editUser(applicant.getUser());
        applicantService.editApplicant(applicant);
    }
}
