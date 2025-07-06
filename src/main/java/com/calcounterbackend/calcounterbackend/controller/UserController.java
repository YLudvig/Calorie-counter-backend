package com.calcounterbackend.calcounterbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.calcounterbackend.calcounterbackend.model.user.UserDTO;
import com.calcounterbackend.calcounterbackend.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
 
    private final UserService userService; 

    @PostMapping("/login")
    public UserDTO loginUser (@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }

    //Denna är enbart för testning, bör definitivt inte finnas vid deploy
    @GetMapping("/getAll")
    public List<UserDTO> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/getById")
    public UserDTO getById(@RequestParam UUID userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

}