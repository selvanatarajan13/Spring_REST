package com.example.RESTAPI.__Restapi_UserSignUp.service;

import com.example.RESTAPI.__Restapi_UserSignUp.Utils;
import com.example.RESTAPI.__Restapi_UserSignUp.dto.UserDTO;
import com.example.RESTAPI.__Restapi_UserSignUp.entity.UserEntity;
import com.example.RESTAPI.__Restapi_UserSignUp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if (userRepository.findByEmail(userDTO.getEmail()) != null) throw new RuntimeException("Record already exists..");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setUserID(utils.generateUserId(10));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));

        UserEntity saveEntity = userRepository.save(userEntity);

        UserDTO userDTO1 = new UserDTO();
        BeanUtils.copyProperties(saveEntity, userDTO1);

        return userDTO1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(username, userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
