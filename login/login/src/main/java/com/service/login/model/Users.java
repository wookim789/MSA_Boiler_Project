package com.service.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;

@Entity(name = "user")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String password;
    private String email;

    protected Users() {

    }
    @Builder
    public Users(final String userId, final String password, final String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public Long getId(){
        return this.id;
    }
    public String getUserId() {
        return this.userId;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
}
