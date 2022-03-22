package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TeacherMapper {
    ArrayList<Teacher> selectAllTeachers();

    int selectUserIdByTeacherId(int id);

    int selectTeacherIdByUserId(int id);

    Teacher selectTeacherByUserId(int id);

    Teacher selectTeacherById(int id);

    Teacher selectTeacherByExamResultId(int id);

    ArrayList<Teacher> selectTeacherByFacultyId(int id);

    void insertTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(int id);
}
