package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.policyRepository")
public interface PolicyRepository extends CrudRepository<Policy, Long> {
    Policy findByUserIdAndRoleId(Long userId, Long roleId);
}
