package com.cipriano.omoi.business;

import com.cipriano.omoi.domain.TodoList;
import com.cipriano.omoi.entity.TodoListEntity;
import com.cipriano.omoi.exceptions.TodoException;
import com.cipriano.omoi.exceptions.TodoListException;
import com.cipriano.omoi.service.TodoListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.cipriano.omoi.utils.OmoiUtils.modelMapper;

public class TodoListBusiness {
    
    private static final Logger logger = LogManager.getLogger(TodoListBusiness.class);

    TodoListService todoListService;

    public TodoListBusiness(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public TodoList getTodoList(String id) throws TodoListException {
        logger.info("TodoListBusiness :: getTodoList :: Start");

        try {
            if(id != null && !id.isEmpty()) {
                logger.info("TodoListBusiness :: getTodoList :: GoTo :: TodoListService");
                logger.debug("TodoListBusiness :: getTodoList :: GoTo :: TodoService {}", id);
                TodoListEntity todoListEntity = this.todoListService.getTodoListEntity(id);
                logger.info("TodoListBusiness :: getTodoList :: Success");
                return modelMapper.map(todoListEntity, TodoList.class);
            }

            logger.info("TodoListBusiness :: getTodoList :: Error Missing Data :: End");
            throw new TodoListException("User get failed. Missing required fields.");

        } catch (TodoListException e) {
            logger.info("TodoListBusiness :: getTodoList :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public TodoList updateTodoList(TodoList todoList) throws TodoListException {
        logger.info("TodoListBusiness :: updateTodoList :: Start");

        try {
            if(todoList != null) {
                logger.info("TodoListBusiness :: updateTodoList :: GoTo :: TodoListService");
                logger.debug("TodoListBusiness :: updateTodoList :: GoTo :: TodoListService {}", todoList.toString());
                TodoListEntity todoListEntity = modelMapper.map(todoList, TodoListEntity.class);
                logger.info("TodoListBusiness :: updateTodoList :: Success");
                return modelMapper.map(todoListEntity, TodoList.class);
            }

            logger.info("TodoListBusiness :: updateTodoList :: Error Missing Data :: End");
            throw new TodoListException("Todo update failed. Missing required fields.");

        } catch (TodoListException e) {
            logger.info("TodoListBusiness :: updateTodoList :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public void deleteTodoList(TodoList todoList) throws TodoListException {
        logger.info("TodoListBusiness :: deleteTodoList :: Start");

        try {
            if(todoList != null) {
                logger.info("TodoListBusiness :: deleteTodoList :: GoTo :: TodoListService");
                logger.debug("TodoListBusiness :: deleteTodoList :: GoTo :: TodoListService {}", todoList.toString());
                TodoListEntity todoListEntity = modelMapper.map(todoList, TodoListEntity.class);
                logger.info("TodoListBusiness :: deleteTodoList :: Success");
                this.todoListService.deleteTodoListEntity(todoListEntity);
            }

            logger.info("TodoListBusiness :: deleteTodoList :: Error Missing Data :: End");
            throw new TodoListException("Todo deletion failed. Missing required fields.");

        } catch (TodoListException e) {
            logger.info("TodoListBusiness :: deleteTodoList :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

    public TodoList createTodoList(TodoList todoList) throws TodoListException {
        logger.info("TodoListBusiness :: createTodoList :: Start");

        try {
            if(todoList != null) {
                logger.info("TodoListBusiness :: createTodoList :: GoTo :: TodoListService");
                logger.debug("TodoListBusiness :: createTodoList :: GoTo :: TodoListService {}", todoList.toString());
                TodoListEntity todoListEntity = modelMapper.map(todoList, TodoListEntity.class);
                logger.info("TodoListBusiness :: createTodoList :: Success");
                return modelMapper.map(this.todoListService.createTodoListEntity(todoListEntity), TodoList.class);
            }

            logger.info("TodoListBusiness :: createTodoList :: Error Missing Data :: End");
            throw new TodoListException("Todo creation failed. Missing required fields.");

        } catch (TodoListException e) {
            logger.info("TodoListBusiness :: createTodoList :: Exception :: End");
            throw new RuntimeException(e);
        }
    }

}
