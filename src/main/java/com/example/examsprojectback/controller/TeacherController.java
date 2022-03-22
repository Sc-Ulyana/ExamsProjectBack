package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Teacher;
import com.example.examsprojectback.service.TeacherService;
import com.example.examsprojectback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @GetMapping("/teachers/")
    public ArrayList<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/teach/{userId}")
    public Teacher getTeacherByUserId(@PathVariable int userId) {
        return teacherService.getTeacherByUserId(userId);
    }

    @GetMapping("/teachers/{id}")
    public ArrayList<Teacher> getTeachersByFacultyId(int id) {
        return teacherService.getTeachersByFacultyId(id);
    }

    @PostMapping("/teachers/")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @PutMapping("/teachers/")
    public void editTeacher(@RequestBody Teacher teacher) {
        teacherService.editTeacher(teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@RequestBody int id) {
        userService.deleteUser(id);
    }
}
