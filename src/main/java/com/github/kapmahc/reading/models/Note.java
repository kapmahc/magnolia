package com.github.kapmahc.reading.models;

import com.github.kapmahc.auth.models.Model;
import com.github.kapmahc.auth.models.User;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "reading_notes",
        indexes = {@Index(columnList = "type")}
)
public class Note extends Model {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private Type type;
    @Lob
    @Column(nullable = false)
    private String body;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(nullable = false)
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
