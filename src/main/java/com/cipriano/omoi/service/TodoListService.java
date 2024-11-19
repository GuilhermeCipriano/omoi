package com.cipriano.omoi.service;

import com.cipriano.omoi.entity.TodoListEntity;
import com.cipriano.omoi.exceptions.TodoListException;
import com.cipriano.omoi.repository.TodoListRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class TodoListService {

    private static final Logger logger = LogManager.getLogger(TodoListService.class);

    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoListEntity getTodoListEntity(String id) throws TodoListException {
        logger.info("TodoListService :: getTodoListEntity :: Start");
        try {
            logger.debug("TodoListService :: getTodoListEntity :: debug :: data: {}", id);
            return todoListRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Todo not found"));
        } catch (DataAccessException e) {
            logger.error("TodoListService :: getTodoListEntity :: Error");

            throw new TodoListException("Could not find todo list", e);
        }
    }

    public Iterable<TodoListEntity> getAllTodoListEntity() throws TodoListException {
        logger.info("TodoListService :: getAllTodoListEntity :: Start");
        try {
            return todoListRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("TodoListService :: getAllTodoListEntity :: Error");
            throw new TodoListException("Could not find all todos' list", e);
        }
    }

    public TodoListEntity createTodoListEntity(TodoListEntity todoListEntity) throws TodoListException {
        logger.info("TodoListService :: createTodoListEntity :: Start");
        try {
            logger.debug("TodoListService :: createTodoListEntity :: debug :: data: {}", todoListEntity.toString());
            return todoListRepository.save(todoListEntity);
        } catch (DataAccessException e) {
            logger.error("TodoListService :: createTodoListEntity :: Error");
            throw new TodoListException("Could not create todo list", e);
        }
    }

    public TodoListEntity updateTodoListEntity(TodoListEntity todoListEntity) throws TodoListException {
        logger.info("TodoListService :: updateTodoListEntity :: Start");

        try {
            logger.debug("TodoListService :: updateTodoListEntity :: debug :: data: {}", todoListEntity.toString());
            return todoListRepository.save(todoListEntity);
        } catch (DataAccessException e) {
            logger.error("TodoListService :: updateTodoListEntity :: Error");

            throw new TodoListException("Could not update todo list", e);
        }
    }

    public void deleteTodoListEntity(TodoListEntity todoListEntity) throws TodoListException {
        logger.info("TodoListService :: deleteTodoListEntity :: Start");
        try {
            logger.debug("TodoListService :: deleteTodoListEntity :: debug :: data: {}", todoListEntity.toString());
            todoListRepository.delete(todoListEntity);
        } catch (DataAccessException e) {
            logger.error("TodoListService :: deleteTodoListEntity :: Error");
            throw new TodoListException("Could not delete todo list", e);
        }
    }

}
