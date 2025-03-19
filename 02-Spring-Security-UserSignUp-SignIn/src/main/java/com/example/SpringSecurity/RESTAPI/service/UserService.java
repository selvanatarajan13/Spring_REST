package com.example.SpringSecurity.RESTAPI.service;

import com.example.SpringSecurity.RESTAPI.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
}
