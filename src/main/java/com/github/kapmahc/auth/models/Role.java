package com.github.kapmahc.auth.models;

import javax.persistence.Entity;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name="roles")
public class Role extends Model {
    private String name;
    private String resourceType;
    private Integer resourceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
