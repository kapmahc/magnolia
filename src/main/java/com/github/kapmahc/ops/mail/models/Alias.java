package com.github.kapmahc.ops.mail.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "mail_aliases")
public class Alias extends Model {
    private String source;
    private String destination;
    @ManyToOne
    private Domain domain;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
