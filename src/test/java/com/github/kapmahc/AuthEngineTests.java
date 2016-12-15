package com.github.kapmahc;

import com.github.kapmahc.auth.helpers.EncryptHelper;
import com.github.kapmahc.auth.services.SettingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

/**
 * Created by flamen on 16-12-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthEngineTests {
    @Test
    public void names(){
        for(String s:new String[]{
                Locale.US.toLanguageTag(),
                Locale.class.getName(),
        }){
            System.out.println(s);
        }
    }

    @Test
    public void hmac() {
        try {
            byte[] code = encryptHelper.hmacSum(hello.getBytes());
            System.out.printf("HMAC('%s') = %s\n", hello, Base64.getEncoder().encodeToString(code));
            Assert.assertTrue(encryptHelper.hmacCheck(code, hello.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void aes() {
        try {
            byte[] code = encryptHelper.encode(hello.getBytes());
            System.out.printf("AES('%s') = %s\n", hello, Base64.getEncoder().encodeToString(code));
            byte[] plain = encryptHelper.decode(code);
            Assert.assertArrayEquals(plain, hello.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void setting() {
        try {
            for (String k : new String[]{"aaa", "bbb", "ccc"}) {
                settingService.set(k, new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }


    @Resource
    EncryptHelper encryptHelper;
    @Resource
    SettingService settingService;
    private final String hello = "Hello, Magnolia!";
}
