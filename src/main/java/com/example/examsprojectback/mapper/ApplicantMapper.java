package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Applicant;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ApplicantMapper{
    ArrayList<Applicant> selectAllApplicants();

    ArrayList<Applicant> selectTopApplicantsByFacultyId(int id);

    int selectUserIdByApplicantId(int id);

    int selectApplicantIdByUserId(int id);

    Applicant selectApplicantById(int id);

    Applicant selectApplicantByExamResultId(int id);

    ArrayList<Applicant> selectApplicantsByFacultyId(int id);

    void insertApplicant(Applicant applicant);

    void updateApplicant(Applicant applicant);

    void updateApplicantAvgMark(Applicant applicant);

    void deleteApplicant(int id);
}
