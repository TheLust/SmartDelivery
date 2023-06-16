package com.endava.SmartDelivery.Service;

import java.util.Collections;

import com.endava.SmartDelivery.DAO.UserDAO;
import com.endava.SmartDelivery.Entity.DTO.UserDTO;
import com.endava.SmartDelivery.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDao;

    private BCryptPasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    public void setPasswordEncoder(final BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDTO user) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername(validateUsername(user.getUsername()));
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setRole(validateAndGetUserRole(user));
        userDao.save(userEntity);
    }

    private String validateUsername(final String username) {
        if (userDao.existsByUsername(username)) {
            throw new RuntimeException("User already registered!");
        }
        return username;
    }

    private String validateAndGetUserRole(UserDTO user) {
        if (user.getRole() == null) {
            return "ROLE_USER";
        } else if (!(user.getRole().equals("ROLE_ADMIN") || user.getRole().equals("ROLE_USER")|| user.getRole().equals("ROLE_COURIER"))) {
            throw new RuntimeException("Invalid role provided!");
        }
        return user.getRole();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.findByUsername(username);
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole()))
        );
    }
}

