package com.example.RESTAPI.__Restapi_UserSignUp.controller;

import com.example.RESTAPI.__Restapi_UserSignUp.dto.UserDTO;
import com.example.RESTAPI.__Restapi_UserSignUp.model.request.UserRequest;
import com.example.RESTAPI.__Restapi_UserSignUp.model.response.UserResponse;
import com.example.RESTAPI.__Restapi_UserSignUp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getMethod() {
        return "This is get method";
    }

    @PostMapping
    public UserResponse postMethod(@RequestBody UserRequest userRequest) {

        UserResponse userResponse = new UserResponse();

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userRequest, userDTO);

        UserDTO userDTO1 = userService.createUser(userDTO);

        BeanUtils.copyProperties(userDTO1, userResponse);

        return userResponse;
    }
}
