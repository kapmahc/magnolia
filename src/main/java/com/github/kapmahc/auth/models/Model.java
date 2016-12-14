package com.github.kapmahc.auth.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
public class Model implements Serializable {
    public enum Type{
        MARKDOWN, HTML
    }
    private int id;
    private Date updatedAt;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
