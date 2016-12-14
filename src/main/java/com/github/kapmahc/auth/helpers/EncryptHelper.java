package com.github.kapmahc.auth.helpers;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Bytes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by flamen on 16-12-13.
 * <p>
 * http://docs.spring.io/spring-security/site/docs/3.1.x/reference/crypto.html
 */
@Component("auth.encryptHelper")
public class EncryptHelper {
    public byte[] hmacSum(byte[] plain) {
        return hashFunction.newHasher().putBytes(plain).hash().asBytes();
    }

    public boolean hmacCheck(byte[] code, byte[] plain) {
        return Arrays.equals(code, hmacSum(plain));
    }

    public byte[] encode(byte[] plain) throws GeneralSecurityException {
        final byte[] salt = new byte[SALT];
        random.nextBytes(salt);

        IvParameterSpec iv = new IvParameterSpec(salt);
        SecretKeySpec spec = new SecretKeySpec(aesKey.getBytes(), AES);

        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, spec, iv);

        return Bytes.concat(cipher.doFinal(plain), salt);
    }

    public byte[] decode(byte[] code) throws GeneralSecurityException {
        IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(code, code.length - SALT, code.length));
        SecretKeySpec spec = new SecretKeySpec(aesKey.getBytes(), AES);

        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.DECRYPT_MODE, spec, iv);
        return cipher.doFinal(Arrays.copyOfRange(code, 0, code.length - SALT));
    }


    @PostConstruct
    void init() {
        hashFunction = Hashing.hmacSha512(hmacKey.getBytes());
        random = new Random();
    }

    @Value("${app.secrets.hmac}")
    String hmacKey;
    @Value("${app.secrets.aes}")
    String aesKey;

    private HashFunction hashFunction;
    private Random random;
    private final int SALT = 16;
    private final String CIPHER = "AES/CBC/PKCS5PADDING";
    private final String AES = "AES";

}
