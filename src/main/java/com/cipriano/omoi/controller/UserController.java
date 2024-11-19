package com.cipriano.omoi.controller;

import com.cipriano.omoi.business.UserBusiness;
import com.cipriano.omoi.domain.User;
import com.cipriano.omoi.exceptions.UserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    UserBusiness userBusiness;


    @GetMapping("/{id}")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<User> getUser(@PathVariable String id) {
        logger.info("UserController :: getUser :: Start");
        try {
            logger.debug("UserController :: getUser :: data {}", id);
            User user = userBusiness.getUser(id);
            logger.info("UserController :: getUser :: success");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserException e) {
            logger.error("UserController :: getUser :: exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("UserController :: createUser :: Start");
        try {
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
