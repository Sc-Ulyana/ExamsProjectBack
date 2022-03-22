package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/role/{id}")
    Role getRole(@PathVariable int id){ return roleService.getRoleById(id);}
}
