package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.roleRepository")
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByNameAndResourceTypeAndResourceId(String name, String resourceType, Long resourceId);
}
