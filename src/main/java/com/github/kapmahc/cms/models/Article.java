package com.github.kapmahc.cms.models;

import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.site.models.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "cms_articles")
public class Article extends Model {
    private String title;
    private String body;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToMany
    private List<Tag> tags;
    @OneToMany
    private List<Comment> comments;
    @ManyToOne
    private User user;

    public Article() {
        tags = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
