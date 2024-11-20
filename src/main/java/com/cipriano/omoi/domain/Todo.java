package com.cipriano.omoi.domain;

import com.cipriano.omoi.entity.TodoListEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Todo {

    private String id;
    private TodoListEntity todoListEntity;
    private String title;
    private String description;
    private boolean completed;
    private boolean favorited;
    private Date createdAt;
    private Date editedAt;


}
