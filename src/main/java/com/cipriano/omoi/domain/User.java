package com.cipriano.omoi.domain;

import lombok.Data;
import java.util.Date;

@Data
public class User {

    private String id;
    private String email;
    private String username;
    private Date createdAt;
    private Date updatedAt;
    private boolean enabled;

}
