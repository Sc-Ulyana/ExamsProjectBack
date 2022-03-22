package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Exam;
import com.example.examsprojectback.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamMapper examMapper;

    @Override
    public ArrayList<Exam> getAllExams() {
        return examMapper.selectAllExams();
    }

    @Override
    public Exam getExamById(int id) {
        return examMapper.selectExamById(id);
    }

    @Override
    public ArrayList<Exam> getExamsByUserId(int id) {
        return examMapper.selectExamsByUserId(id);
    }

    @Override
    public void addExam(Exam exam) {
        examMapper.insertExam(exam);
    }

    @Override
    public void editExam(Exam exam) {
        examMapper.updateExam(exam);
    }

    @Override
    public void deleteExam(int id) {
        examMapper.deleteExam(id);
    }
}
