package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Exam;
import com.example.examsprojectback.domain.Faculty;
import com.example.examsprojectback.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ExamMapper{
    ArrayList<Exam> selectAllExams();

    ArrayList<Exam> selectExamsByUserId(int id);

    Exam selectExamById(int id);

    Exam selectExamByExamFacultyId(int id);

    void updateExam(Exam exam);

    void insertExam(Exam exam);

    void deleteExam(int id);
}
