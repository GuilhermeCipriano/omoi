package com.cipriano.omoi.business;

import com.cipriano.omoi.domain.User;
import com.cipriano.omoi.entity.UserEntity;
import com.cipriano.omoi.exceptions.UserException;
import com.cipriano.omoi.service.UserService;
import com.cipriano.omoi.utils.Constants;
import static com.cipriano.omoi.utils.OmoiUtils.modelMapper;

public class UserBusiness {

    UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public User getUser(String id) throws UserException {

        try {
            if(id != null && !id.isEmpty()) {
                UserEntity userEntity = this.userService.getUserEntity(id);
                return modelMapper.map(userEntity, User.class);
            }

            throw new UserException("User get failed. Missing required fields.");

        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    public User updateUser(User user) throws UserException {

        try {
            if(user != null && user.getId() != null) {
                UserEntity userEntity = modelMapper.map(user, UserEntity.class);
                return modelMapper.map(userService.updateUserEntity(userEntity), User.class);
            }

            throw new UserException("User update failed. Missing required fields.");

        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    public User deleteUser(User user) throws UserException {

        try {
            if(user != null && user.getId() != null) {
                UserEntity userEntity = modelMapper.map(user, UserEntity.class);
                userEntity.setEnabled(Constants.USER_DISABLED);
                return modelMapper.map(this.userService.deleteUserEntity(userEntity), User.class);
            }

            throw new UserException("User deletion failed. Missing required fields.");

        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    public User createUser(User user) throws UserException {

        try {
            if(user != null && user.getId() != null) {
                UserEntity userEntity = modelMapper.map(user, UserEntity.class);
                return modelMapper.map(this.userService.createUserEntity(userEntity), User.class);
            }

            throw new UserException("User creation failed. Missing required fields.");

        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

}