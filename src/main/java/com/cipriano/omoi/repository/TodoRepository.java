package com.cipriano.omoi.repository;

import com.cipriano.omoi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, String> { }
