package com.github.kapmahc.ops.jobs;

import com.github.kapmahc.auth.helpers.JsonHelper;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by flamen on 16-12-15.
 */
@Component("ops.taskSender")
public class TaskSender {


    public void send(String queue, String... args) {
        try {
            MessageBufferPacker mbp = MessagePack.newDefaultBufferPacker();
            String id = UUID.randomUUID().toString();
            mbp
                    .packString(queue)
                    .packString(id);
            mbp.packArrayHeader(args.length);
            for (String s : args) {
                mbp.packString(s);
            }
            mbp.close();

            logger.info("Push task {} into {}", id, queue);
            template.convertAndSend("tasks",new String(mbp.toByteArray()));
        } catch (IOException e) {
            logger.error("Ops!", e);
        }
    }


    @Resource
    StringRedisTemplate template;
    @Resource
    JsonHelper jsonHelper;
    private static final Logger logger = LoggerFactory.getLogger(TaskSender.class);
}
