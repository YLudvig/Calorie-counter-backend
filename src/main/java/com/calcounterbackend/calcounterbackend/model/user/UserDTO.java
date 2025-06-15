package com.calcounterbackend.calcounterbackend.model.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID userId; 
    private String name; 
    private String email; 
    private String password; 
    private String token; 

    public static User DTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user; 
    }

    public UserDTO(UUID userId, String name, String email, String password){
        this.userId = userId; 
        this.name = name; 
        this.email = email; 
        this.password = password; 
    }
}
