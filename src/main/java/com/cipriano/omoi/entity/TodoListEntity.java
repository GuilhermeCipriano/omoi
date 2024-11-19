package com.cipriano.omoi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "todoList")
@Table(name = "todo_list")
@Data
public class TodoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userEntity;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "last_edited_at")
    private Date lastEditedAt;

}
