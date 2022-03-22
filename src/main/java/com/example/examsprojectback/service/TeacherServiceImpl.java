package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Teacher;
import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.mapper.RoleMapper;
import com.example.examsprojectback.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserService userService;

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = teacherMapper.selectAllTeachers();
        for (Teacher teacher : teachers) {
            teacher.setUser(userService.getUser(getUserIdByTeacherId(teacher.getId())));
        }
        return teachers;
    }

    @Override
    public Teacher getTeacherByUserId(int id) {
        Teacher teacher = teacherMapper.selectTeacherByUserId(id);
        if(teacher != null){
            teacher.setUser(userService.getUser(getUserIdByTeacherId(teacher.getId())));
        }
        return teacher;
    }

    @Override
    public Teacher getTeacher(int id) {
        Teacher teacher = teacherMapper.selectTeacherById(id);
        teacher.setUser(userService.getUser(getUserIdByTeacherId(teacher.getId())));
        return teacher;
    }



    @Override
    public ArrayList<Teacher> getTeachersByFacultyId(int id) {
        ArrayList<Teacher> teachers = teacherMapper.selectTeacherByFacultyId(id);
        for (Teacher teacher : teachers) {
            teacher.setUser(userService.getUser(getUserIdByTeacherId(teacher.getId())));
        }
        return teachers;
    }

    @Override
    public int getTeacherIdByUserId(int id) {
        return teacherMapper.selectTeacherIdByUserId(id);
    }

    @Override
    public int getUserIdByTeacherId(int id) {
        return teacherMapper.selectUserIdByTeacherId(id);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacher.getUser().setRole(roleMapper.selectRoleByRoleId(2));
        userService.addUser(teacher.getUser());
        User user = userService.getUser(teacher.getUser().getLogin());
        teacher.setUser(user);
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void editTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherMapper.deleteTeacher(id);
    }
}
