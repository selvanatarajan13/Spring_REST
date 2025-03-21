package com.example.SpringSecurity.RESTAPI.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.RESTAPI.dto.UserDTO;
import com.example.SpringSecurity.RESTAPI.entity.UserEntity;
import com.example.SpringSecurity.RESTAPI.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userDTO, userEntity);
		
		userEntity.setUserId("abc123");
		userEntity.setEncryptedPassword(userDTO.getPassword());
		
		UserEntity createUser = userRepository.save(userEntity);
		
		UserDTO userDTO1 = new UserDTO();
		BeanUtils.copyProperties(createUser, userDTO1);
		
		return userDTO1;
	}

}
