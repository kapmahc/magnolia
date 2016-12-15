package com.github.kapmahc.ops.mail.models;

import com.github.kapmahc.auth.models.Model;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "mail_aliases")
@Table(
        indexes = {
                @Index(columnList = "destination"),
        }
)
@DynamicUpdate
public class Alias extends Model {
    @Column(nullable = false, unique = true)
    private String source;
    @Column(nullable = false)
    private String destination;
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
