package com.zeng.repository;

import com.zeng.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Guan on 9/2/2018.
 */
public interface UserRepository  extends MongoRepository<UserEntity, String> {
    Page<UserEntity> findAll(Pageable pageable);
    UserEntity findById(String id);
    UserEntity findByUserNameOrEmail(String userName,String email);
    UserEntity findByUserName(String userName);
    UserEntity findByEmail(String email);
    Long deleteById(String id);
}