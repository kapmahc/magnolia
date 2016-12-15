package com.github.kapmahc.auth.models;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "contacts",
        indexes = {
                @Index(columnList = "key, user_id", unique = true),
                @Index(columnList = "key")
        }
)
public class Contact extends Model {
    @Column(nullable = false)
    private String key;
    @Column(nullable = false)
    private String val;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
