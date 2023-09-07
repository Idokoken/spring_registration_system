package com.ndgroups.userRegisteration.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Registration info" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '.';
    }
}

