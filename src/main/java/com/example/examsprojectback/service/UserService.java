package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.domain.User;

import java.util.ArrayList;

public interface UserService {
    ArrayList<User> getAllUsers();

    ArrayList<User> getUsersByFacultyId(int id);

    ArrayList<Role> getAllRoles();

    User checkUser(String login, String password);

    User getUser(int id);

    User getUser(String login);

    void addUser(User user);

    void editUser(User user);

    boolean editUserPass(String login, String oldPassword, String newPassword, String newPasswordRepeat);

    void deleteUser(int id);
}
