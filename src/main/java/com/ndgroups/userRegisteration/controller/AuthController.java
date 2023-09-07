package com.ndgroups.userRegisteration.controller;


import com.ndgroups.userRegisteration.dto.LoginResponseDTO;
import com.ndgroups.userRegisteration.dto.RegistrationDTO;
import com.ndgroups.userRegisteration.model.ApplicationUser;
import com.ndgroups.userRegisteration.service.AuthenticationService;
import com.ndgroups.userRegisteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO userDTO) {
        return authenticationService.registerUser(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO userDTO) {
        return authenticationService.loginUser(userDTO.getUsername(), userDTO.getPassword());
    }


}

