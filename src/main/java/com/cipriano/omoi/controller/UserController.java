package com.cipriano.omoi.controller;

import com.cipriano.omoi.business.UserBusiness;
import com.cipriano.omoi.domain.User;
import com.cipriano.omoi.exceptions.UserException;
import com.cipriano.omoi.utils.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final String USER_URL = Strings.BASE_URL + "/user";

    UserBusiness userBusiness;
    @Autowired
    public UserController(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @GetMapping(USER_URL + "/{id}")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<User> getUser(@PathVariable String id) {
        logger.info("UserController :: getUser :: Start");
        try {
            logger.debug("UserController :: getUser :: data {}", id);
            User user = userBusiness.getUser(id);
            logger.info("UserController :: getUser :: success");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("UserController :: getUser :: exception");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(USER_URL + "/")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("UserController :: createUser :: Start");
        try {
            if(user.getId() != null && !user.getId().isEmpty()) {
                throw new UserException("UserController :: createUser :: User id already exists");
            }

            if( (user.getUsername() == null || user.getUsername().isEmpty() )
                || (user.getEmail() == null || user.getEmail().isEmpty() )
                    || (user.getPassword() == null || user.getPassword().isEmpty() )
            ) {
                throw new UserException("UserController :: createUser :: Username, password and email address required");
            }

            logger.debug("UserController :: createUser :: data {}", user.toString());
            User createdUser = userBusiness.createUser(user);
            logger.info("UserController :: createUser :: success");
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (UserException e) {
            logger.error("UserController :: createUser :: exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
