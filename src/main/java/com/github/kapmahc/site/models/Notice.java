package com.github.kapmahc.site.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "notices",
        indexes = {
                @Index(columnList = "type"),
        }
)
public class Notice extends Model {
    @Lob
    @Column(nullable = false)
    private String body;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
