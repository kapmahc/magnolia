package com.github.kapmahc.site.models;

import com.github.kapmahc.auth.models.Model;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "votes")
@Table(
        indexes = {
                @Index(columnList = "resourceType"),
                @Index(columnList = "resourceType, resourceId", unique = true),
        }
)
@DynamicUpdate
public class Vote extends Model {
    @Column(nullable = false)
    private String resourceType;
    private int resourceId;
    private int point;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
