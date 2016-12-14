package com.github.kapmahc.auth.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "contacts")
public class Contact extends Model {
    private String key;
    private String val;
    @ManyToOne
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
