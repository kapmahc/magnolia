package com.github.kapmahc.ops.jobs;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by flamen on 16-12-16.
 */
@Component("ops.jobSender")
public class JobSender {
    public void send(String act, byte[] body) {
        send(act, MessageProperties.CONTENT_TYPE_BYTES, body);
    }

    public void send(String act, String body) {
        send(act, MessageProperties.CONTENT_TYPE_TEXT_PLAIN, body.getBytes());
    }

    private void send(String act, String type, byte[] body) {
        Message msg = MessageBuilder
                .withBody(body)
                .setContentType(type)
                .setMessageId(UUID.randomUUID().toString())
                .setHeader("act", act).build();
        template.send(queueName, msg);
    }

    @Value("#{'${app.name}'+'.jobs'}")
    String queueName;
    @Resource
    AmqpTemplate template;

    public String getQueueName() {
        return queueName;
    }
}
