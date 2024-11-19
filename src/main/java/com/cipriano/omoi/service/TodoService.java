package com.cipriano.omoi.service;

import com.cipriano.omoi.entity.TodoEntity;
import com.cipriano.omoi.exceptions.TodoException;
import com.cipriano.omoi.repository.TodoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class TodoService {

    private static final Logger logger = LogManager.getLogger(TodoService.class);

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoEntity getTodoEntity(String id) throws TodoException {
        logger.info("TodoService :: getTodoEntity :: Start");

        try {
            logger.debug("TodoService :: getTodoEntity :: data {}", id);
            return todoRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Todo not found"));
        } catch (DataAccessException e) {
            logger.error("TodoService :: getTodoEntity :: Error");
            throw new TodoException("Could not find todo", e);
        }
    }

    public Iterable<TodoEntity> getAllTodoEntity() throws TodoException {
        logger.info("TodoService :: getAllTodoEntity :: Start");
        try {

            return todoRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("TodoService :: getTodoEntity :: Error");
            throw new TodoException("Could not find all todos'", e);
        }
    }

    public TodoEntity createTodoEntity(TodoEntity todoEntity) throws TodoException {
        logger.info("TodoService :: createTodoEntity :: Start");
        try {
            logger.debug("TodoService :: createTodoEntity :: data {}", todoEntity.toString());
            return todoRepository.save(todoEntity);
        } catch (DataAccessException e) {
            logger.error("TodoService :: getTodoEntity :: Error");
            throw new TodoException("Could not create todo", e);
        }
    }

    public TodoEntity updateTodoEntity(TodoEntity todoEntity) throws TodoException {
        logger.info("TodoService :: updateTodoEntity :: Start");
        try {
            logger.debug("TodoService :: updateTodoEntity :: data {}", todoEntity.toString());
            return todoRepository.save(todoEntity);
        } catch (DataAccessException e) {
            logger.error("TodoService :: getTodoEntity :: Error");
            throw new TodoException("Could not update todo", e);
        }
    }

    public void deleteTodoEntity(TodoEntity todoEntity) throws TodoException {
        logger.info("TodoService :: deleteTodoEntity :: Start");
        try {
            logger.debug("TodoService :: deleteTodoEntity :: data {}", todoEntity.toString());
            todoRepository.delete(todoEntity);
        } catch (DataAccessException e) {
            logger.error("TodoService :: getTodoEntity :: Error");
            throw new TodoException("Could not delete todo", e);
        }
    }

}
