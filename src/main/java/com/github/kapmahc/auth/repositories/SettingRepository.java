package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Setting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.settingRepository")
public interface SettingRepository extends CrudRepository<Setting, Long> {
    Setting findByKeyAndUserId(String key, Long userId);
}
