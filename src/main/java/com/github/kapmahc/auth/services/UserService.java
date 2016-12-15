package com.github.kapmahc.auth.services;

import com.github.kapmahc.auth.helpers.EncryptHelper;
import com.github.kapmahc.auth.models.Log;
import com.github.kapmahc.auth.models.User;
import com.github.kapmahc.auth.repositories.LogRepository;
import com.github.kapmahc.auth.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by flamen on 16-12-13.
 */
@Service("auth.userService")
public class UserService {
    public User addUser(String fullName, String email, String password) {
        User u = new User();
        u.setFullName(fullName);
        u.setEmail(email);
        u.setPassword(encryptHelper.hmacSum(password.getBytes()));
        u.setProviderId(email);
        u.setProviderType(User.Type.EMAIL);
        u.setUid(UUID.randomUUID().toString());

        userRepository.save(u);
        return u;
    }

    public void log(User user, String message) {
        log(user, message, Log.Type.INFO);
    }


    public void log(User user, String message, Log.Type type) {
        Log l = new Log();
        l.setMessage(message);
        l.setUser(user);
        l.setType(type);
        logRepository.save(l);
    }

    @Resource
    UserRepository userRepository;
    @Resource
    LogRepository logRepository;
    @Resource
    EncryptHelper encryptHelper;


}
