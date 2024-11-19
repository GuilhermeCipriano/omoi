package com.cipriano.omoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity(name = "todo")
@Table(name = "todo")
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    private TodoListEntity todoListEntity;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "favorited", nullable = false)
    private boolean favorited;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "edited_at")
    private Date editedAt;

}
