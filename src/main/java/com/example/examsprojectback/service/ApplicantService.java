package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Applicant;

import java.util.ArrayList;

public interface ApplicantService {
    ArrayList<Applicant> getAllApplicants();

    ArrayList<Applicant> getTopApplicantsByFacultyId(int id);

    int getUserIdByApplicantId(int id);

    ArrayList<Applicant> getApplicantsByFacultyId(int id);

    int getApplicantIdByUserId(int id);

    Applicant getApplicant(int id);

    void addApplicant(Applicant applicant);

    void editApplicant(Applicant applicant);

    void updateApplicantAvgMark(Applicant applicant);

    void deleteApplicant(int id);
}
