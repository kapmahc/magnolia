package com.github.kapmahc.auth.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
public class Log implements Serializable {
    public enum Type {
        INFO, WARNING, ERROR
    }
    private int id;
    private User user;
    private Type type;
    private String message;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
