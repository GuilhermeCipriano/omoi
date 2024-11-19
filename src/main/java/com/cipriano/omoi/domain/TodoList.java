package com.cipriano.omoi.domain;

import com.cipriano.omoi.entity.UserEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TodoList {

    private String id;
    private UserEntity userEntity;
    private String title;
    private boolean active;
    private Date createdAt;
    private Date lastEditedAt;

}
