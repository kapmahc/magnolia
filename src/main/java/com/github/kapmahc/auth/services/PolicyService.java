package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.models.Policy;
import com.github.kapmahc.auth.models.Role;
import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.auth.repositories.PolicyRepository;
import com.github.kapmahc.auth.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.policyService")
public class PolicyService {
    public void apply(User user, String role) {
        Date now = new Date();
        apply(user, role, now, years(now, YEARS));
    }

    public void apply(User user, String role, Date begin, Date end) {
        apply(user, role, null, null, begin, end);
    }

    public <T> void apply(User user, String role, Class<T> resourceType) {
        Date now = new Date();
        apply(user, role, resourceType, now, years(now, YEARS));
    }

    public <T> void apply(User user, String role, Class<T> resourceType, Date begin, Date end) {
        apply(user, role, resourceType, null, begin, end);
    }

    public <T> void apply(User user, String role, Class<T> resourceType, Long resourceId) {
        Date now = new Date();
        apply(user, role, resourceType, resourceId, now, years(now, YEARS));
    }

    public <T> void apply(User user, String role, Class<T> resourceType, Long resourceId, Date begin, Date end) {
        Role r = getRole(role, resourceType, resourceId);
        Policy p = policyRepository.findByUserIdAndRoleId(user.getId(), r.getId());
        if (p == null) {
            p = new Policy();
            p.setUser(user);
            p.setRole(r);
        }
        p.setStartUp(begin);
        p.setShutDown(end);
        policyRepository.save(p);
    }

    public void deny(long user, String role) {
        deny(user, role, null, null);
    }

    public <T> void deny(long user, String role, Class<T> resourceType) {
        deny(user, role, resourceType, null);
    }

    public <T> void deny(long user, String role, Class<T> resourceType, Long resourceId) {
        Role r = getRole(role, resourceType, resourceId);
        Policy p = policyRepository.findByUserIdAndRoleId(user, r.getId());
        if (p != null) {
            policyRepository.delete(p);
        }
    }

    public boolean can(long user, String role) {
        return can(user, role, null, null);
    }

    public <T> boolean can(long user, String role, Class<T> resourceType) {
        return can(user, role, resourceType, null);
    }

    public <T> boolean can(long user, String role, Class<T> resourceType, Long resourceId) {
        Role r = getRole(role, resourceType, resourceId);
        Policy p = policyRepository.findByUserIdAndRoleId(user, r.getId());
        Date now = new Date();
        return p != null && now.after(p.getStartUp()) && now.before(p.getShutDown());
    }

    private <T> Role getRole(String name, Class<T> resourceType, Long resourceId) {
        String type = resourceType == null ? null : resourceType.getName();
        Role r = roleRepository.findByNameAndResourceTypeAndResourceId(name, type, resourceId);
        if (r == null) {
            r = new Role();
            r.setName(name);
            r.setResourceId(resourceId);
            r.setResourceType(type);
            roleRepository.save(r);
        }
        return r;
    }

    private Date years(Date d, int n) {
        ZoneId zi = ZoneId.systemDefault();
        LocalDateTime ldt = d.toInstant().atZone(zi).toLocalDateTime().plusYears(n);
        return Date.from(ldt.atZone(zi).toInstant());
    }

    @Resource
    PolicyRepository policyRepository;
    @Resource
    RoleRepository roleRepository;
    private final static int YEARS = 20;
}
