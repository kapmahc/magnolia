package com.github.kapmahc.site.models;

import com.github.kapmahc.auth.models.Model;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "notices")
@Table(
        indexes = {
                @Index(columnList = "type"),
        }
)
@DynamicUpdate
public class Notice extends Model {
    @Lob
    @Column(nullable = false)
    private String body;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private Type type;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
