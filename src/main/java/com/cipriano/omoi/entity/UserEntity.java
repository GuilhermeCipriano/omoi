package com.cipriano.omoi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity(name = "userEntity")
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private TodoListEntity todoListEntity;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "edited_at", nullable = false)
    private Date edited_at;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;


}
