package com.cipriano.omoi.controller;

import com.cipriano.omoi.business.TodoBusiness;
import com.cipriano.omoi.domain.Todo;
import com.cipriano.omoi.exceptions.TodoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private static final Logger logger = LogManager.getLogger(TodoController.class);

    TodoBusiness todoBusiness;


    @GetMapping("/{id}")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Todo> getTodo(@PathVariable String id) {
        logger.info("TodoController :: getTodo :: Start");
        try {
            logger.debug("TodoController :: getTodo :: data {}", id);
            Todo todo = todoBusiness.getTodo(id);
            logger.info("TodoController :: getTodo :: success");
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (TodoException e) {
            logger.error("TodoController :: getTodo :: exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
