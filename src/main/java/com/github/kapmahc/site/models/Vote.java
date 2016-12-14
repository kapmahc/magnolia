package com.github.kapmahc.site.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.Entity;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "votes")
public class Vote extends Model {
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
