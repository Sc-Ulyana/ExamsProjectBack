package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Faculty;
import com.example.examsprojectback.domain.FacultyExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface FacultyExamMapper {
    ArrayList<FacultyExam> selectAllFacultyExams();

    ArrayList<FacultyExam> selectFacultyExamByUserId(int id);

    FacultyExam selectFacultyExamById(int id);

    FacultyExam selectFacultyExamByResultId(int id);

    ArrayList<FacultyExam> selectNotPassedExamsByApplicantId(int id);

    void insertFacultyExam(Faculty faculty);

    void updateFacultyExam(Faculty faculty);

    void deleteFacultyExam(int id);
}
