package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Applicant;
import com.example.examsprojectback.domain.Result;

import java.util.ArrayList;

public interface ResultService {

    ArrayList<Result> getResultsByApplicantId(int id);

    ArrayList<Result> getResultsByUserId(int id);

    Result getResultById(int id);

    void addResult(Result result);

    void editResult(Result result);
}
