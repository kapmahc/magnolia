package com.github.kapmahc.cms.models;

import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.site.models.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "cms_comments")
public class Comment extends Model {
    private String body;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private Article article;
    @ManyToOne
    private User user;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
