package com.ndgroups.userRegisteration;

import com.ndgroups.userRegisteration.model.ApplicationUser;
import com.ndgroups.userRegisteration.model.Role;
import com.ndgroups.userRegisteration.repository.RoleRepository;
import com.ndgroups.userRegisteration.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserRegisterationApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserRegisterationApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole  =  roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"admin", passwordEncoder.encode("password"), roles);
			userRepository.save(admin);

		};
	}
}