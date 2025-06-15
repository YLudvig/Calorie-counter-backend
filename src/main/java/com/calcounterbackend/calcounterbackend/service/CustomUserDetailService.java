package com.calcounterbackend.calcounterbackend.service;

import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.model.user.User;
import com.calcounterbackend.calcounterbackend.repository.UserRepository;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                
                //Om roller läggs in behöver det åtgärdas bland annat här tror jag
                Collections.emptyList());
    }

}
