package com.github.kapmahc.site.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "leave_words")
public class LeaveWord implements Serializable {
    @Id
    private long id;
    private String body;
    @Enumerated(EnumType.STRING)
    private Model.Type type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void setCreatedAt() {
        createdAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
