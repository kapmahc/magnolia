package com.github.kapmahc.reading.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
        @Table(
                name = "reading_books",
                indexes = {
                        @Index(columnList = "author"),
                        @Index(columnList = "publisher"),
                        @Index(columnList = "title"),
                        @Index(columnList = "type"),
                        @Index(columnList = "lang"),
                        @Index(columnList = "subject"),
                }
        )
public class Book extends Model {
    public enum Type {
        EPUB3, EPUB2
    }
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private Type type;
    @Column(nullable = false, length = 8)
    private String lang;
    @Column(nullable = false, unique = true)
    private String file;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false, length = 800)
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date publishedAt;
    @OneToMany(mappedBy = "book")
    private List<Note> notes;

    public Book() {
        notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}
