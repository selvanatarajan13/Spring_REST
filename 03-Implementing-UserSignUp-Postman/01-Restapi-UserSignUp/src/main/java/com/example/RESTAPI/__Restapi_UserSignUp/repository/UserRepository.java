package com.example.RESTAPI.__Restapi_UserSignUp.repository;

import com.example.RESTAPI.__Restapi_UserSignUp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
