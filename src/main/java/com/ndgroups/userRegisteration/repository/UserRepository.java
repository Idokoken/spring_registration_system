package com.ndgroups.userRegisteration.repository;

import com.ndgroups.userRegisteration.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
    //    User findByEmail(String email);
    Optional<ApplicationUser> findUserByUsername(String username);
}