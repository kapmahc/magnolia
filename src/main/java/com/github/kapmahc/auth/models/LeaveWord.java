package com.github.kapmahc.auth.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
public class LeaveWord implements Serializable{
    private Model.Type type;
    private int id;
    private String body;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model.Type getType() {
        return type;
    }

    public void setType(Model.Type type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
