package com.github.kapmahc.auth.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "policies")
public class Policy extends Model {
    @ManyToOne
    private User user;
    @ManyToOne
    private Role role;
    private Date startUp;
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
