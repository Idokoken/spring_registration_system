package com.ndgroups.userRegisteration.service;

import com.ndgroups.userRegisteration.dto.LoginResponseDTO;
import com.ndgroups.userRegisteration.model.ApplicationUser;
import com.ndgroups.userRegisteration.model.Role;
import com.ndgroups.userRegisteration.repository.RoleRepository;
import com.ndgroups.userRegisteration.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0, username, encodedPassword, authorities));

    }

    public LoginResponseDTO loginUser(String username, String password) {
        try {
            Authentication auth  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token  = tokenService.generateJwt(auth);
            return new LoginResponseDTO(userRepository.findUserByUsername(username).get(), token);
        }catch (AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }

    }

}
