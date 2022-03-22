package com.example.examsprojectback.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
