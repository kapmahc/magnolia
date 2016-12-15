package com.github.kapmahc.auth.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
        @Table(
                name = "users",
                indexes = {
                        @Index(columnList = "fullName"),
                        @Index(columnList = "providerType"),
                        @Index(columnList = "providerId, providerType", unique = true),
                }
        )
public class User extends Model {
    public enum Type {
        EMAIL
    }
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 36, unique = true)
    private String uid;
    private byte[] password;
    @Column(nullable = false)
    private String providerId;
    @Column(nullable = false, length = 16)
    private Type providerType;
    private String home;
    private String logo;
    private int signInCount;
    private Date currentSignInAt;
    private String currentSignInIp;
    private Date lastSignInAt;
    private String lastSignInIp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmedAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedAt;
    @OneToMany(mappedBy = "user")
    private List<Log> logs;
    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;


    public User() {
        logs = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Type getProviderType() {
        return providerType;
    }

    public void setProviderType(Type providerType) {
        this.providerType = providerType;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public int getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(int signInCount) {
        this.signInCount = signInCount;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(String currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Date getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(Date lockedAt) {
        this.lockedAt = lockedAt;
    }
}
