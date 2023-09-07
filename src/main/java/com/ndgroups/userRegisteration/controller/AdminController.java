package com.ndgroups.userRegisteration.controller;

import com.ndgroups.userRegisteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getAdminDashboard() {
        return "hello admin";
    }

    @GetMapping("/user")
    public String getUsers() {
//        return new ResponseEntity<String>("hello all users", HttpStatus.OK);
        return "hello users";
    }

}