package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Exam;
import com.example.examsprojectback.domain.Faculty;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface FacultyMapper {
    ArrayList<Faculty> selectAllFaculties();

    Faculty selectFacultyByUserId(int id);

    Faculty selectFacultyByExamFacultyId(int id);

    Faculty selectFacultyById(int id);

    Faculty selectFacultyByName(String name);

    void updateFaculty(Faculty faculty);

    void insertFaculty(Faculty faculty);

    void deleteFaculty(int id);
}
