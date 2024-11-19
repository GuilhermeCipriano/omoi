package com.cipriano.omoi.service;

import com.cipriano.omoi.entity.UserEntity;
import com.cipriano.omoi.exceptions.UserException;
import com.cipriano.omoi.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserEntity(String id) throws UserException {
        logger.info("UserService :: getUserEntity :: Start");
        try {
            logger.debug("UserService :: getUserEntity :: data {}", id);
            return userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("User not found"));
        } catch (DataAccessException e) {
            throw new UserException("Could not find user", e);
        }
    }

    public UserEntity createUserEntity(UserEntity userEntity) throws UserException {
        logger.info("UserService :: createUserEntity :: Start");
        try {
            logger.debug("UserService :: createUserEntity :: data {}", userEntity.toString());
            return userRepository.save(userEntity);
        } catch (DataAccessException e) {
            throw new UserException("Could not create user", e);
        }
    }

    public UserEntity updateUserEntity(UserEntity userEntity) throws UserException {
        logger.info("UserService :: updateUserEntity :: Start");
        try {
            logger.debug("UserService :: updateUserEntity :: data {}", userEntity.toString());
            return userRepository.save(userEntity);
        } catch (DataAccessException e) {
            throw new UserException("Could not update user", e);
        }
    }

    public UserEntity deleteUserEntity(UserEntity userEntity) throws UserException {
        logger.info("UserService :: deleteUserEntity :: Start");
        try {
            logger.debug("UserService :: deleteUserEntity :: data {}", userEntity.toString());
            return userRepository.save(userEntity);
        } catch (DataAccessException e) {
            throw new UserException("Could not delete user", e);
        }
    }

}
