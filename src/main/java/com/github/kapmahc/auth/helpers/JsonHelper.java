package com.github.kapmahc.auth.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by flamen on 16-12-14.
 */
@Component("auth.jsonPackHelper")
public class JsonHelper {
    public String obj2str(Object obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }

    public <T> T str2obj(String str, Class<T> clazz) throws IOException {
        return mapper.readValue(str, clazz);
    }

    public byte[] object2bytes(Object obj) throws IOException {
        return mapper.writeValueAsBytes(obj);
    }

    public <T> T bytes2object(byte[] buf, Class<T> clazz) throws IOException {
        return mapper.readValue(buf, clazz);
    }

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    private ObjectMapper mapper;
}
