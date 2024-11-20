package com.cipriano.omoi.domain;

import lombok.Data;
import java.util.Date;

@Data
public class User {

    public String id;
    private String email;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private boolean enabled;

}
