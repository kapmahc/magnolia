package com.github.kapmahc.auth.models;

/**
 * Created by flamen on 16-12-13.
 */
public class Notice extends Model {
    private String body;
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
