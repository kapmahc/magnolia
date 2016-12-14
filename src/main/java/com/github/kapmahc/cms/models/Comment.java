package com.github.kapmahc.cms.models;

import com.github.kapmahc.auth.models.Model;
import com.github.kapmahc.auth.models.User;

/**
 * Created by flamen on 16-12-13.
 */
public class Comment extends Model {
    private String body;
    private Type type;

    private Article article;
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
