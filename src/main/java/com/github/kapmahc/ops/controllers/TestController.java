package com.github.kapmahc.ops.controllers;

import com.github.kapmahc.ops.jobs.JobReceiver;
import com.github.kapmahc.ops.jobs.JobSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by flamen on 16-12-15.
 */
@Controller("ops.testController")

public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public void testTask() {
        jobSender.send("echo", "Hello, " + new Date());
    }

    @PostConstruct
    void init() {
        jobReceiver.register("echo", (id, type, body) -> {
            logger.info(new String(body));
        });
    }

    @Resource
    JobSender jobSender;
    @Resource
    JobReceiver jobReceiver;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
}
