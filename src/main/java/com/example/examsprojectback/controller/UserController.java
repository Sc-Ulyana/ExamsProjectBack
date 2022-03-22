package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/roles")
    ArrayList<Role> getAllRoles(){return userService.getAllRoles();}

    @GetMapping("/users")
    ArrayList<User> getAllUsers(){return userService.getAllUsers();}
//
//    @GetMapping("/users/{id}")
//    User getUser(@PathVariable int id){ return  userService.getUser(id);}
//
    @GetMapping("/users/{login}")
    User getUser(@PathVariable String login){
        return  userService.getUser(login);
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){ userService.addUser(user);}

    @PutMapping("/users/")
    void updateUser(@RequestBody User user){userService.editUser(user);}

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id){ userService.deleteUser(id);}
}
