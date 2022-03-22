package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.*;
import com.example.examsprojectback.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private ApplicantMapper applicantMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private FacultyExamMapper facultyExamMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private FacultyMapper facultyMapper;

    public Teacher getTeacherByResult(int id) {
        Teacher teacher = teacherMapper.selectTeacherByExamResultId(id);
        teacher.setUser(userMapper.selectUserById(teacherMapper.selectUserIdByTeacherId(teacher.getId())));
        teacher.getUser().setRole(roleMapper.selectUserRoleByUserId(teacher.getUser().getId()));
        teacher.getUser().setFaculty(facultyMapper.selectFacultyByUserId(teacher.getUser().getId()));
        return teacher;
    }

    public Applicant getApplicantByResult(int id) {
        Applicant applicant = applicantMapper.selectApplicantByExamResultId(id);
        applicant.setUser(userMapper.selectUserById(applicantMapper.selectUserIdByApplicantId(applicant.getId())));
        applicant.getUser().setRole(roleMapper.selectUserRoleByUserId(applicant.getUser().getId()));
        applicant.getUser().setFaculty(facultyMapper.selectFacultyByExamFacultyId(applicant.getUser().getId()));
        return applicant;
    }

    public FacultyExam getFacultyExamByResult(int id) {
        FacultyExam facultyExam = facultyExamMapper.selectFacultyExamByResultId(id);
        facultyExam.setExam(examMapper.selectExamByExamFacultyId(facultyExam.getId()));
        facultyExam.setFaculty(facultyMapper.selectFacultyByExamFacultyId(facultyExam.getId()));
        return facultyExam;
    }

    @Override
    public ArrayList<Result> getResultsByApplicantId(int id) {
        ArrayList<Result> results = resultMapper.selectResultsByApplicantId(id);
        for (Result result : results) {
            if (result != null) {
                result.setTeacher(getTeacherByResult(result.getId()));
                result.setApplicant(getApplicantByResult(result.getId()));
                result.setFacultyExam(getFacultyExamByResult(result.getId()));
            }
        }
        return results;
    }

    @Override
    public ArrayList<Result> getResultsByUserId(int id) {
        ArrayList<Result> results = resultMapper.selectResultsByUserId(id);
        for (Result result : results) {
            if (result != null) {
                result.setTeacher(getTeacherByResult(result.getId()));
                result.setApplicant(getApplicantByResult(result.getId()));
                result.setFacultyExam(getFacultyExamByResult(result.getId()));
            }
        }
        return results;
    }

    @Override
    public Result getResultById(int id) {
        Result result = resultMapper.selectResultById(id);
        if (result != null) {
            result.setTeacher(getTeacherByResult(result.getId()));
            result.setApplicant(getApplicantByResult(result.getId()));
            result.setFacultyExam(getFacultyExamByResult(id));
        }
        return result;
    }

    @Override
    public void addResult(Result result) {
        resultMapper.insertResult(result);
    }

    @Override
    public void editResult(Result result) {
        resultMapper.updateResult(result);
    }
}
