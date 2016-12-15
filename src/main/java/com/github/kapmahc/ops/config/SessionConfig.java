package com.github.kapmahc.ops.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by flamen on 16-12-14.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
