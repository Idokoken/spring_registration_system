package com.ndgroups.userRegisteration.service;

import com.ndgroups.userRegisteration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
//@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        return userRepository.findUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("user not valid"));
//        if(!username.equals("ethans")) throw new UsernameNotFoundException("not ethans");
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1, "USER"));
//        return new ApplicationUser(1, "ethan", passwordEncoder.encode("password"), roles);
    }
//    public void addUser(User user);
//    public User findUserByEmail(String email);
//    public List<UserDto> findAllUsers();
////    public List<User> getAllUsers();
////    public Optional<User>getOneUser(Integer id);
//    public Optional<User> updateUser(User user);
//    public void deleteUser(Integer id);

}

