package com.github.kapmahc.auth.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "policies",
        indexes = {
                @Index(columnList = "role_id, user_id", unique = true),
        }
)
public class Policy extends Model {
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startUp;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date shutDown;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getStartUp() {
        return startUp;
    }

    public void setStartUp(Date startUp) {
        this.startUp = startUp;
    }

    public Date getShutDown() {
        return shutDown;
    }

    public void setShutDown(Date shutDown) {
        this.shutDown = shutDown;
    }
}
