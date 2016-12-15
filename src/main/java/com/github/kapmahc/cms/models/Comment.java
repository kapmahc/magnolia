package com.github.kapmahc.cms.models;

import com.github.kapmahc.auth.models.Model;
import com.github.kapmahc.auth.models.User;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "cms_comments")
@Table(
        indexes = @Index(columnList = "type")
)
@DynamicUpdate
public class Comment extends Model {
    @Lob
    @Column(nullable = false)
    private String body;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private Type type;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;
    @ManyToOne
    @JoinColumn(nullable = false)
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
