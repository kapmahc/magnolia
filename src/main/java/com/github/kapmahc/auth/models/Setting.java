package com.github.kapmahc.auth.models;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "settings",
        indexes = {
                @Index(columnList = "key"),
                @Index(columnList = "key, user_id", unique = true),
        }
)
public class Setting extends Model {
    @Column(nullable = false)
    private String key;
    @Column(nullable = false)
    private byte[] val;
    private boolean flag;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getVal() {
        return val;
    }

    public void setVal(byte[] val) {
        this.val = val;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
