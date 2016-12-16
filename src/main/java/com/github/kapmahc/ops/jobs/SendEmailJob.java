package com.github.kapmahc.ops.jobs;

import com.github.kapmahc.auth.services.SettingService;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by flamen on 16-12-16.
 */
@Component("ops.sendEmailJob")
public class SendEmailJob {
    @PostConstruct
    void init(){
        jobReceiver.register("email", (id, type, buf)->{
            try{
                MessageUnpacker mu = MessagePack.newDefaultUnpacker(buf);
                String to = mu.unpackString();
                String subject = mu.unpackString();
                String body = mu.unpackString();
                mu.close();
                //TODO
                logger.debug("SEND MAIL TO {}:\n{}\n{}", to, subject, body);
            }catch (IOException e){
                logger.error("Ops!", e);
            }

        });
    }
    @Resource
    SettingService settingService;
    @Resource
    JobReceiver jobReceiver;
    private static final Logger logger = LoggerFactory.getLogger(SendEmailJob.class);
}
