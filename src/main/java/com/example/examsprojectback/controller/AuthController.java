package com.example.examsprojectback.controller;

import com.example.examsprojectback.domain.User;
import com.example.examsprojectback.config.jwt.JwtProvider;
import com.example.examsprojectback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request, HttpServletResponse response) throws IOException {
        User userEntity = userService.checkUser(request.getLogin(), request.getPassword());
        if (userEntity == null) {
            response.sendError(401);
            return null;
        }
        String token = jwtProvider.generateToken(userEntity);
        return new AuthResponse(token);
    }

}

