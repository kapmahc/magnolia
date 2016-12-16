package com.github.kapmahc.ops.controllers;

import com.github.kapmahc.ops.jobs.TaskReceiver;
import com.github.kapmahc.ops.jobs.TaskSender;
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
        taskSender.send("echo", "Hello, " + new Date().toString());
    }

    @PostConstruct
    void init() {
        taskReceiver.register("echo", (String... args) -> {
            logger.info("ECHO {}", args[0]);
        });
    }

    @Resource
    TaskSender taskSender;
    @Resource
    TaskReceiver taskReceiver;
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
}
