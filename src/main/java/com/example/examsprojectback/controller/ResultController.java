package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Result;
import com.example.examsprojectback.service.ApplicantService;
import com.example.examsprojectback.service.ApplicantServiceImpl;
import com.example.examsprojectback.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/results/applicant/{applicantId}")
    public ArrayList<Result> getResultsByApplicantId(@PathVariable int applicantId) {
        return resultService.getResultsByApplicantId(applicantId);
    }

    @GetMapping("/results/{id}")
    public ArrayList<Result> getResultsByUserId(@PathVariable int id) {
        return resultService.getResultsByUserId(id);
    }

    @GetMapping("/result/{id}")
    public Result getResultById(@PathVariable int id) {
        return resultService.getResultById(id);
    }

    @PostMapping("/results/")
    public void addResult(@RequestBody Result result) {
        resultService.addResult(result);
        applicantService.updateApplicantAvgMark(result.getApplicant());
    }

    @PutMapping("/results/")
    public void editResult(@RequestBody Result result) {
        resultService.editResult(result);
        applicantService.updateApplicantAvgMark(result.getApplicant());
    }
}
