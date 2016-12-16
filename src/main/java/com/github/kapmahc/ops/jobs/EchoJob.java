package com.github.kapmahc.ops.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by flamen on 16-12-16.
 */
@Component("ops.echoJob")
public class EchoJob implements MessageListener {


    @Override
    public void onMessage(Message message) {
        logger.info(new String(message.getBody()));
    }

    private static final Logger logger = LoggerFactory.getLogger(EchoJob.class);
}
