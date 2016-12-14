package com.github.kapmahc;

import com.github.kapmahc.ops.mail.utils.SSha512Crypt;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by flamen on 16-12-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpsMailTests {

    @Test
    public void ssha512() {
        try {
            String password = "Hello, Magnolia!";
            String code = crypt.sum(password);
            Assert.assertTrue(crypt.check(code, password));
            System.out.println(crypt.test(password));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Resource
    SSha512Crypt crypt;
}
