package com.example.SpringSecurity.RESTAPI.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.SpringSecurity.RESTAPI.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.SpringSecurity.RESTAPI.model.request.UserReqModel;
import com.example.SpringSecurity.RESTAPI.model.response.UserResModel;
import com.example.SpringSecurity.RESTAPI.dto.UserDTO;



@RestController
@RequestMapping("users")
public class FunRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public String getMethod() {
		return "This endpoint return a GET method";
	}
	
	
	@PostMapping()
	public UserResModel addUser(@RequestBody UserReqModel userReqModel) {
		
		UserResModel userResModel = new UserResModel();
		
		UserDTO userDTO = new UserDTO();
		
		BeanUtils.copyProperties(userReqModel, userDTO);
		
		UserDTO userDTO1 = userService.createUser(userDTO);
		
		BeanUtils.copyProperties(userDTO1, userResModel);
		
		return userResModel;
	}
	
	@PutMapping()
	public String putMethod() {
		return "This endpoint was return put method";
	}
	
}
