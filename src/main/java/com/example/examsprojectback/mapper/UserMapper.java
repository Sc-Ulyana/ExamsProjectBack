package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    ArrayList<User> selectAllUsers();

    ArrayList<User> selectUsersByFacultyId(int id);

    User selectUserByExamResultId(int id);

    User selectUserById(int id);

    User selectUserByLogin(String login);

    void updateUser(User user);

    void updatePassByLogin(String login,String password);

    void insertUser(User user);

    void deleteUser(int id);

}
