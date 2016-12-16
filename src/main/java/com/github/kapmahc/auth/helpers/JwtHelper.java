package com.github.kapmahc.auth.helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by flamen on 16-12-16.
 */
@Component("auth.JwtHelper")
public class JwtHelper {

    public DecodedJWT parse(String token) {
        return verifier.verify(token);
    }

    public String generate(JWTCreator.Builder builder, int days) {

        Date now = new Date();
        ZoneId zi = ZoneId.systemDefault();
        LocalDateTime ldt = now.toInstant().atZone(zi).toLocalDateTime().plusYears(days);
        return builder
                .withIssuer(name)
                .withIssuedAt(now)
                .withExpiresAt(Date.from(ldt.atZone(zi).toInstant()))
                .sign(algorithm);
    }

    @PostConstruct
    void init() throws UnsupportedEncodingException {
        algorithm = Algorithm.HMAC512(key);
        verifier = JWT.require(algorithm).withIssuer(name).build();
    }

    @Value("${app.secrets.jwt}")
    String key;
    @Value("${app.name}")
    String name;
    private Algorithm algorithm;
    private JWTVerifier verifier;
}
