package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Teacher;

import java.util.ArrayList;

public interface TeacherService {
    ArrayList<Teacher> getAllTeachers();

    Teacher getTeacherByUserId(int id);

    int getUserIdByTeacherId(int id);

    ArrayList<Teacher> getTeachersByFacultyId(int id);

    int getTeacherIdByUserId(int id);

    Teacher getTeacher(int id);

    void addTeacher(Teacher teacher);

    void editTeacher(Teacher teacher);

    void deleteTeacher(int id);
}
