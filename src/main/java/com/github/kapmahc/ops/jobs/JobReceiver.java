package com.github.kapmahc.ops.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by flamen on 16-12-16.
 */
@Component("ops.jobReceiver")
public class JobReceiver implements MessageListener {


    public interface Callback {
        void run(String id, String contentType, byte[] body);
    }

    public void register(String act, Callback callback) {
        logger.info("Register task callback to {}", act);
        if (callbacks.get(act) != null) {
            logger.warn("Already exists, will override it!");
        }
        callbacks.put(act, callback);
    }

    @Override
    public void onMessage(Message msg) {
        MessageProperties mp = msg.getMessageProperties();
        logger.info("Receive task {}", mp.getMessageId());

        String act = (String) mp.getHeaders().get("act");
        Callback cb = callbacks.get(act);
        if (cb == null) {
            logger.error("Unknown action {}", act);
            return;
        }
        cb.run(mp.getMessageId(), mp.getContentType(), msg.getBody());
        logger.info("Done.");
    }

    @PostConstruct
    void init() {
        callbacks = new HashMap<>();
    }

    private Map<String, Callback> callbacks;
    private static final Logger logger = LoggerFactory.getLogger(JobReceiver.class);
}
