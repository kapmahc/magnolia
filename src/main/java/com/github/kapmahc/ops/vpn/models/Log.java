package com.github.kapmahc.ops.vpn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "vpn_logs")
public class Log implements Serializable {
    @Id
    private long id;
    private String trustedIp;
    private int trustedPort;
    private String remoteIp;
    private int remotePort;
    private double send;
    private double received;
    private Date startUp;
    private Date shutDown;
    @ManyToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrustedIp() {
        return trustedIp;
    }

    public void setTrustedIp(String trustedIp) {
        this.trustedIp = trustedIp;
    }

    public int getTrustedPort() {
        return trustedPort;
    }

    public void setTrustedPort(int trustedPort) {
        this.trustedPort = trustedPort;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public double getSend() {
        return send;
    }

    public void setSend(double send) {
        this.send = send;
    }

    public double getReceived() {
        return received;
    }

    public void setReceived(double received) {
        this.received = received;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
