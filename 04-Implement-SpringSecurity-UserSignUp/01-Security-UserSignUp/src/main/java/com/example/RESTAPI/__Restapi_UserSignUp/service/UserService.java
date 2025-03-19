package com.example.RESTAPI.__Restapi_UserSignUp.service;

import com.example.RESTAPI.__Restapi_UserSignUp.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);
}
