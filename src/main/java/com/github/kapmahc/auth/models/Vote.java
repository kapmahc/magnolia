package com.github.kapmahc.auth.models;

/**
 * Created by flamen on 16-12-13.
 */

public class Vote extends Model {
    private String resourceType;
    private int resourceId;

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
