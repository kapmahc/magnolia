package com.github.kapmahc.site.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "notices")
public class Notice extends Model {
    private String body;
    @Enumerated(EnumType.STRING)
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
