package com.github.kapmahc.reading.models;

import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.site.models.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "reading_notes")
public class Note extends Model {
    @Enumerated(EnumType.STRING)
    private Type type;
    private String body;
    @ManyToOne
    private Book book;
    @ManyToOne
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
