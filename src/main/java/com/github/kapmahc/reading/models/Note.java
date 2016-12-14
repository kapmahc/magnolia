package com.github.kapmahc.reading.models;

import com.github.kapmahc.auth.models.Model;
import com.github.kapmahc.auth.models.User;

/**
 * Created by flamen on 16-12-13.
 */
public class Note extends Model {
    private Type type;
    private String body;

    private Book book;
    private User user;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
