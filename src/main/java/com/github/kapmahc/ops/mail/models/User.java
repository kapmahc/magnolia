package com.github.kapmahc.ops.mail.models;

import com.github.kapmahc.auth.models.Model;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "mail_users")
@Table(
        indexes = {
                @Index(columnList = "fullName"),
        }
)
@DynamicUpdate
public class User extends Model {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Domain domain;
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
