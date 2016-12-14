package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.helpers.EncryptHelper;
import com.github.kapmahc.auth.helpers.JsonHelper;
import com.github.kapmahc.auth.models.Setting;
import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.auth.repositories.SettingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by flamen on 16-12-14.
 */
@Service("auth.settingService")
public class SettingService {
    public void set(String key, Object val) throws IOException, GeneralSecurityException {
        set(key, null, val, false);
    }

    public void set(String key, Object val, boolean flag) throws IOException, GeneralSecurityException {
        set(key, null, val, flag);
    }

    public void set(String key, User user, Object val) throws IOException, GeneralSecurityException {
        set(key, user, val, false);
    }

    public void set(String key, User user, Object val, boolean flag) throws IOException, GeneralSecurityException {
        Setting s = settingRepository.findByKeyAndUserId(key, user == null ? null : user.getId());
        if (s == null) {
            s = new Setting();
            s.setKey(key);
            s.setUser(user);
        }
        byte[] buf = jsonHelper.object2bytes(val);
        if (flag) {
            buf = encryptHelper.encode(buf);
        }
        s.setVal(buf);
        settingRepository.save(s);
    }

    public <T> T get(String key, Class<T> clazz) throws IOException, GeneralSecurityException {
        return get(key, null, clazz);
    }

    public <T> T get(String key, Long user, Class<T> clazz) throws IOException, GeneralSecurityException {
        Setting s = settingRepository.findByKeyAndUserId(key, user);
        if (s == null) {
            return null;
        }
        byte[] buf = s.isFlag() ? encryptHelper.decode(s.getVal()) : s.getVal();
        return jsonHelper.bytes2object(buf, clazz);
    }

    @Resource
    SettingRepository settingRepository;
    @Resource
    EncryptHelper encryptHelper;
    @Resource
    JsonHelper jsonHelper;

}
