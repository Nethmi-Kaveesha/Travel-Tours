package com.example.travel_tours.service;


import com.example.travel_tours.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}