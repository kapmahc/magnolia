package com.github.kapmahc.ops.mail.utils;

import com.google.common.primitives.Bytes;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * Created by flamen on 16-12-13.
 */
@Component("ops.mail.sSha512Crypt")
public class SSha512Crypt {
    public String sum(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final byte[] salt = new byte[SALT];
        random.nextBytes(salt);
        return sum(password, salt);
    }

    public boolean check(String code, String password) {
        try {
            byte[] buf = Base64.getDecoder().decode(code);
            return code.equals(sum(password, Arrays.copyOfRange(buf, buf.length - SALT, buf.length)));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String test(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return String.format("doveadm pw -t '{SSHA512}%s' -p '%s'", sum(password), password);
    }

    private String sum(String password, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(CHARSET));
        md.update(salt);
        return Base64.getEncoder().encodeToString(Bytes.concat(md.digest(), salt));
    }

    @PostConstruct
    void init() {
        random = new Random();
    }

    private Random random;
    private final int SALT = 16;
    private final Charset CHARSET = StandardCharsets.UTF_8;
}
