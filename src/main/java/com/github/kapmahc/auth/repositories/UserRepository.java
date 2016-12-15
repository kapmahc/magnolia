package com.github.kapmahc.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.userRepository")
public interface UserRepository extends CrudRepository<com.github.kapmahc.auth.models.User, Long> {
    com.github.kapmahc.auth.models.User findByEmail(String email);
}
