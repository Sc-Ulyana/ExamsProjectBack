package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Exam;

import java.util.ArrayList;

public interface ExamService {
    ArrayList<Exam> getAllExams();

    Exam getExamById(int id);

    ArrayList<Exam> getExamsByUserId(int id);

    void addExam(Exam exam);

    void editExam(Exam exam);

    void deleteExam(int id);
}
