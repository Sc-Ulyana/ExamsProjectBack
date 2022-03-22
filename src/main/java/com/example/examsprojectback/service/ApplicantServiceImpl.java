package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Applicant;
import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantMapper applicantMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int getUserIdByApplicantId(int id) {
            return applicantMapper.selectUserIdByApplicantId(id);
    }

    @Override
    public int getApplicantIdByUserId(int id) {
            return applicantMapper.selectApplicantIdByUserId(id);
    }

    public void getUserByApplicant(Applicant applicant) {
        applicant.setUser(userMapper.selectUserById(getUserIdByApplicantId(applicant.getId())));
        applicant.getUser().setRole(roleMapper.selectUserRoleByUserId(applicant.getUser().getId()));
        applicant.getUser().setFaculty(facultyMapper.selectFacultyByUserId(applicant.getUser().getId()));
    }

    @Override
    public ArrayList<Applicant> getAllApplicants() {
        ArrayList<Applicant> applicants = applicantMapper.selectAllApplicants();
        for (Applicant applicant : applicants) {
            getUserByApplicant(applicant);
        }
        return applicants;
    }

    @Override
    public ArrayList<Applicant> getTopApplicantsByFacultyId(int id) {
        ArrayList<Applicant> applicants = applicantMapper.selectTopApplicantsByFacultyId(id);
        for (Applicant applicant : applicants) {
            getUserByApplicant(applicant);
        }
        return applicants;
    }

    @Override
    public Applicant getApplicant(int id) {
        Applicant applicant = applicantMapper.selectApplicantById(id);
        if (applicant != null) {
            getUserByApplicant(applicant);
        }
        return applicant;
    }

    @Override
    public ArrayList<Applicant> getApplicantsByFacultyId(int id) {
        ArrayList<Applicant> applicants = applicantMapper.selectApplicantsByFacultyId(id);
        for (Applicant applicant : applicants) {
            getUserByApplicant(applicant);
        }
        return applicants;
    }

    @Override
    public void addApplicant(Applicant applicant) {
        applicant.getUser().setRole(roleMapper.selectRoleByRoleId(1));
        if (userMapper.selectUserByLogin(applicant.getUser().getLogin()) == null) {
            applicant.getUser().setPassword(bCryptPasswordEncoder.encode(applicant.getUser().getPassword()));
            userMapper.insertUser(applicant.getUser());
        }
        User user = userMapper.selectUserByLogin(applicant.getUser().getLogin());
        applicant.setUser(user);
        applicantMapper.insertApplicant(applicant);
    }

    @Override
    public void editApplicant(Applicant applicant) {
        applicantMapper.updateApplicant(applicant);
    }

    @Override
    public void updateApplicantAvgMark(Applicant applicant) {
        if (resultMapper.selectCountOfApplicantResults(applicant.getId()) == 3) {
            applicantMapper.updateApplicantAvgMark(applicant);
        } else {
            System.out.println("Not all exams passed");
        }
    }

    @Override
    public void deleteApplicant(int id) {
        applicantMapper.deleteApplicant(id);
    }
}
