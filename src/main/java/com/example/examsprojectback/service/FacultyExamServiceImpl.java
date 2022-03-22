package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.FacultyExam;
import com.example.examsprojectback.mapper.ExamMapper;
import com.example.examsprojectback.mapper.FacultyExamMapper;
import com.example.examsprojectback.mapper.FacultyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FacultyExamServiceImpl implements FacultyExamService {
    @Autowired
    private FacultyExamMapper facultyExamMapper;

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private ExamMapper examMapper;

    public ArrayList<FacultyExam> getAllFacultyExams() {
        ArrayList<FacultyExam> facultyExams = facultyExamMapper.selectAllFacultyExams();
        for (FacultyExam facultyExam : facultyExams) {
            facultyExam.setFaculty(facultyMapper.selectFacultyByExamFacultyId(facultyExam.getId()));
            facultyExam.setExam(examMapper.selectExamByExamFacultyId(facultyExam.getId()));
        }
        return facultyExams;
    }

    @Override
    public FacultyExam getFacultyExamById(int id) {
        FacultyExam facultyExam = facultyExamMapper.selectFacultyExamById(id);
        facultyExam.setFaculty(facultyMapper.selectFacultyByExamFacultyId(facultyExam.getId()));
        facultyExam.setExam(examMapper.selectExamByExamFacultyId(facultyExam.getId()));
        return facultyExam;
    }

    @Override
    public ArrayList<FacultyExam> getFacultyExamByApplicantId(int id) {
        ArrayList<FacultyExam> facultyExams = facultyExamMapper.selectFacultyExamByUserId(id);
        for (FacultyExam facultyExam : facultyExams) {
            facultyExam.setFaculty(facultyMapper.selectFacultyByExamFacultyId(facultyExam.getId()));
            facultyExam.setExam(examMapper.selectExamByExamFacultyId(facultyExam.getId()));
        }
        return facultyExams;
    }

    @Override
    public ArrayList<FacultyExam> getNotPassedExams(int id) {
        ArrayList<FacultyExam> facultyExams = facultyExamMapper.selectNotPassedExamsByApplicantId(id);
        for (FacultyExam facultyExam : facultyExams) {
            facultyExam.setExam(examMapper.selectExamByExamFacultyId(facultyExam.getId()));
            facultyExam.setFaculty(facultyMapper.selectFacultyByExamFacultyId(facultyExam.getId()));
        }
        return facultyExams;
    }
}
