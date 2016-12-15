package com.github.kapmahc.auth.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "roles",
        indexes = {
                @Index(columnList = "name"),
                @Index(columnList = "resourceType"),
        }
)
public class Role extends Model {
    @Column(nullable = false, length = 32)
    private String name;
    private String resourceType;
    private Long resourceId;
    @OneToMany(mappedBy = "role")
    private List<Policy> policies;

    public Role() {
        policies = new ArrayList<>();
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

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

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
