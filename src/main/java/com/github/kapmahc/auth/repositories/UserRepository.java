package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
}
