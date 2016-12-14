package com.github.kapmahc.ops.models.mail;

import com.github.kapmahc.auth.models.Model;

/**
 * Created by flamen on 16-12-13.
 */
public class Alias extends Model {
    private String source;
    private String destination;

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
