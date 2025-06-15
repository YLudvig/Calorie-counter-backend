package com.calcounterbackend.calcounterbackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.calcounterbackend.calcounterbackend.Util.JwtUtil;
import com.calcounterbackend.calcounterbackend.model.user.User;
import com.calcounterbackend.calcounterbackend.model.user.UserDTO;
import com.calcounterbackend.calcounterbackend.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository; 
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtils; 
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtils){
        this.userRepository = userRepository; 
        this.passwordEncoder = passwordEncoder; 
        this.authenticationManager = authenticationManager; 
        this.jwtUtils = jwtUtils; 
    }

    public UserDTO loginUser(UserDTO userDTO){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                userDTO.getEmail(), 
                userDTO.getPassword()));
        userDTO.setUserId(userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getUserId());
        User user = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtUtils.generateToken(userDTO.getEmail(), userDTO.getUserId());
            return new UserDTO(
                user.getUserId(), 
                user.getName(), 
                user.getEmail(), 
                user.getPassword(), 
                token
            );
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getPassword()))
                .toList();
    }

    public UserDTO getUserById(UUID userId){
        return userRepository.findById(userId)
                .map(user -> new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getPassword()))
                .orElse(null);
    }

    public UserDTO register(UserDTO userDTO){
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already in use!");
        }
        String encodedPasssword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPasssword);
        userRepository.save(UserDTO.DTOToUser(userDTO)).getUserId();
        return userDTO;
    }
}
