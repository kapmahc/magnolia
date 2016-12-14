package com.github.kapmahc.site.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Model implements Serializable {
    public enum Type {
        MARKDOWN, HTML
    }

    @Id
    private long id;
    private Date updatedAt;
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
