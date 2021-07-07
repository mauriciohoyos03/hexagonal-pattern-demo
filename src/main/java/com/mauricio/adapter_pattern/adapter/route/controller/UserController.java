package com.mauricio.adapter_pattern.adapter.route.controller;

import com.mauricio.adapter_pattern.domain.UserService;
import com.mauricio.adapter_pattern.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping( value = "/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
