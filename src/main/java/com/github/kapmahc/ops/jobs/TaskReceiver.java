package com.github.kapmahc.ops.jobs;

import com.github.kapmahc.auth.helpers.JsonHelper;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by flamen on 16-12-15.
 */
@Component("ops.taskReceiver")
public class TaskReceiver {

    public interface Callback {
        void run(String... args);
    }

    public void register(String queue, Callback cb) {
        logger.info("Register task callback for queue {}", queue);
        if (callbacks.get(queue) != null) {
            logger.warn("Queue {} already registed", queue);
        }
        callbacks.put(queue, cb);
    }


    @PostConstruct
    void init() {
        callbacks = new HashMap<>();
    }

    public void receiveMessage(String message) {
        String id, queue;

        String[] args;

        try {
            MessageUnpacker mu = MessagePack.newDefaultUnpacker(message.getBytes());
            queue = mu.unpackString();
            id = mu.unpackString();
            int len = mu.unpackArrayHeader();
            args = new String[len];
            for (int i = 0; i < len; i++) {
                args[i] = mu.unpackString();
            }
            mu.close();
            logger.info("Received task: {} from queue {}", id, queue);

            Callback cb = callbacks.get(queue);
            if (cb == null) {
                logger.error("Ignore...");
                return;
            }
            cb.run(args);
        } catch (IOException e) {
            logger.error("Ops", e);
        }
    }

    @Resource
    JsonHelper jsonHelper;
    @Resource
    StringRedisTemplate template;
    private Map<String, Callback> callbacks;
    private static final Logger logger = LoggerFactory.getLogger(TaskReceiver.class);

}
