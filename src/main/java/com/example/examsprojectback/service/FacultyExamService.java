package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Faculty;
import com.example.examsprojectback.domain.FacultyExam;

import java.util.ArrayList;

public interface FacultyExamService {
    ArrayList<FacultyExam> getAllFacultyExams();

    FacultyExam getFacultyExamById(int id);

    ArrayList<FacultyExam> getFacultyExamByApplicantId(int id);

    ArrayList<FacultyExam> getNotPassedExams(int id);
}
