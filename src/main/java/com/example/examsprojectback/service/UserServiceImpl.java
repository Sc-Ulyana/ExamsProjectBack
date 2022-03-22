package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.mapper.ApplicantMapper;
import com.example.examsprojectback.mapper.FacultyMapper;
import com.example.examsprojectback.mapper.RoleMapper;
import com.example.examsprojectback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicantMapper applicantMapper;

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ArrayList<Role> getAllRoles() {
        return roleMapper.selectAllRoles();
    }

    @Override
    public User checkUser(String login, String password) {
        User userEntity = getUser(login);
        if (userEntity != null) {
            if (bCryptPasswordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = userMapper.selectAllUsers();
        for (User user : users) {
            if (user != null) {
                user.setFaculty(facultyMapper.selectFacultyByUserId(user.getId()));
                user.setRole(roleMapper.selectUserRoleByUserId(user.getId()));
            }
        }
        return users;
    }

    @Override
    public ArrayList<User> getUsersByFacultyId(int id) {
        return userMapper.selectUsersByFacultyId(id);
    }

    @Override
    public User getUser(int id) {
        User user = userMapper.selectUserById(id);
        if (user != null) {
            user.setRole(roleMapper.selectUserRoleByUserId(id));
            user.setFaculty(facultyMapper.selectFacultyByUserId(id));
        }
        return user;
    }

    @Override
    public User getUser(String login) {
        User user = userMapper.selectUserByLogin(login);
        if (user != null) {
            user.setRole(roleMapper.selectUserRoleByUserId(user.getId()));
            user.setFaculty(facultyMapper.selectFacultyByUserId(user.getId()));
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        if (userMapper.selectUserByLogin(user.getLogin()) == null) {
            userMapper.insertUser(user);
            System.out.println(user);
        } else {
            System.out.println("user already exist");
        }
    }

    @Override
    public void editUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public boolean editUserPass(String login, String oldPassword, String newPassword, String newPasswordRepeat) {
        for (User user : userMapper.selectAllUsers()) {
            if (user.getLogin().equals(login)) {
                if (new BCryptPasswordEncoder().matches(oldPassword, user.getPassword())) {
                    if (newPassword.equals(newPasswordRepeat)) {
                        userMapper.updatePassByLogin(login, bCryptPasswordEncoder.encode(newPasswordRepeat));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }


}
