package com.cipriano.omoi.business;

import com.cipriano.omoi.domain.Todo;
import com.cipriano.omoi.entity.TodoEntity;
import com.cipriano.omoi.exceptions.TodoException;
import com.cipriano.omoi.service.TodoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.cipriano.omoi.utils.OmoiUtils.modelMapper;

public class TodoBusiness {

    private static final Logger logger = LogManager.getLogger(TodoBusiness.class);

    TodoService todoService;

    public TodoBusiness(TodoService todoService) {
        this.todoService = todoService;
    }

    public Todo getTodo(String id) throws TodoException {
        logger.info("TodoBusiness :: getTodo :: Start");

        try {
            if(id != null && !id.isEmpty()) {
                logger.info("TodoBusiness :: getTodo :: GoTo :: TodoService");
                logger.debug("TodoBusiness :: getTodo :: GoTo :: TodoService {}", id);
                TodoEntity todoEntity = this.todoService.getTodoEntity(id);
                logger.info("TodoBusiness :: getTodo :: Success");
                return modelMapper.map(todoEntity, Todo.class);
            }

            logger.info("TodoBusiness :: getTodo :: Error Missing Data :: End");
            throw new TodoException("User get failed. Missing required fields.");

        } catch (TodoException e) {
            logger.info("TodoBusiness :: getTodo :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public Todo updateTodo(Todo todo) throws TodoException {
        logger.info("TodoBusiness :: updateTodo :: Start");

        try {
            if(todo != null && todo.getId() != null) {
                TodoEntity todoEntity = modelMapper.map(todo, TodoEntity.class);
                logger.info("TodoBusiness :: updateTodo :: GoTo :: TodoService");
                this.todoService.updateTodoEntity(todoEntity);
                logger.info("TodoBusiness :: getTodo :: Success");
                return modelMapper.map(todoEntity, Todo.class);
            }

            logger.info("TodoBusiness :: updateTodo :: Error Missing Data :: End");
            throw new TodoException("Todo update failed. Missing required fields.");

        } catch (TodoException e) {
            logger.info("TodoBusiness :: updateTodo :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public void deleteTodo(Todo todo) throws TodoException {
        logger.info("TodoBusiness :: deleteTodo :: Start");

        try {
            if(todo != null && todo.getId() != null) {
                TodoEntity todoEntity = modelMapper.map(todo, TodoEntity.class);
                logger.info("TodoBusiness :: deleteTodo :: GoTo :: TodoService");
                this.todoService.deleteTodoEntity(todoEntity);
                logger.info("TodoBusiness :: deleteTodo :: Success");
            }

            logger.info("TodoBusiness :: deleteTodo :: Error Missing Data :: End");
            throw new TodoException("Todo deletion failed. Missing required fields.");

        } catch (TodoException e) {
            logger.info("TodoBusiness :: deleteTodo :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public Todo createTodo(Todo todo) throws TodoException {
        logger.info("TodoBusiness :: createTodo :: Start");

        try {
            if(todo != null && todo.getId() != null) {
                TodoEntity todoEntity = modelMapper.map(todo, TodoEntity.class);
                logger.info("TodoBusiness :: createTodo :: GoTo :: TodoService");
                return modelMapper.map(this.todoService.createTodoEntity(todoEntity), Todo.class);
            }

            logger.info("TodoBusiness :: createTodo :: Error Missing Data :: End");
            throw new TodoException("Todo creation failed. Missing required fields.");

        } catch (TodoException e) {
            logger.info("TodoBusiness :: createTodo :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

}
