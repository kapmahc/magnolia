package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.logRepository")
public interface LogRepository extends CrudRepository<Log, Long> {
}
