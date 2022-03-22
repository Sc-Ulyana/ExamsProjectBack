package com.example.examsprojectback.controller;

import com.example.examsprojectback.config.jwt.JwtProvider;
import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/roles")
    ArrayList<Role> getAllRoles(){return userService.getAllRoles();}

    @GetMapping("/users")
    ArrayList<User> getAllUsers(){return userService.getAllUsers();}

    @GetMapping("/users/{login}")
    User getUser(@PathVariable String login){
        return  userService.getUser(login);
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){ userService.addUser(user);}

    @PutMapping("/changePassword/")
    boolean changePassword(@RequestBody Map<String, String> passwords, @RequestHeader("Authorization") String authorization){
        authorization = authorization.substring(7);
        User user = userService.getUser(jwtProvider.getLoginFromToken(authorization));
        if(userService.editUserPass(user.getLogin(), passwords.get("oldPass"), passwords.get("newPass"), passwords.get("newPassRepeat"))){
            System.out.println("password change");
            return true;
        }
        else return false;
    }

    @PutMapping("/users/")
    void updateUser(@RequestBody User user){userService.editUser(user);}

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id){ userService.deleteUser(id);}
}
