package com.cipriano.omoi.repository;

import com.cipriano.omoi.entity.TodoListEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoListEntity, String> { }
