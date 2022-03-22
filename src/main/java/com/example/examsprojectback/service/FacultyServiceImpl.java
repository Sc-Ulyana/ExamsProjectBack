package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Faculty;
import com.example.examsprojectback.mapper.FacultyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyMapper facultyMapper;

    @Override
    public ArrayList<Faculty> getAllFaculties() {
        return facultyMapper.selectAllFaculties();
    }
}

