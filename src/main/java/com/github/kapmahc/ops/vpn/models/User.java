package com.github.kapmahc.ops.vpn.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "vpn_users",
        indexes = {@Index(columnList = "fullName")}
)
public class User extends Model {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Lob
    @Column(nullable = false)
    private String details;
    private boolean online;
    private boolean enable;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startUp;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date shutDown;
    @OneToMany(mappedBy = "user")
    private List<Log> logs;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User() {
        logs = new ArrayList<>();
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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
