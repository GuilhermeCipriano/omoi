package com.cipriano.omoi.controller;

import com.cipriano.omoi.business.TodoListBusiness;
import com.cipriano.omoi.domain.TodoList;
import com.cipriano.omoi.exceptions.TodoListException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-list")
public class TodoListController {

    private static final Logger logger = LogManager.getLogger(TodoListController.class);

    TodoListBusiness todoListBusiness;


    @GetMapping("/{id}")
//    @ExceptionHandler(UserException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<TodoList> getTodoList(@PathVariable String id) {
        logger.info("TodoListController :: getTodoList :: Start");
        try {
            logger.debug("TodoListController :: getTodoList :: data {}", id);
            TodoList todoList = todoListBusiness.getTodoList(id);
            logger.info("TodoListController :: getTodoList :: success");
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } catch (TodoListException e) {
            logger.error("TodoListController :: getTodoList :: exception");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
