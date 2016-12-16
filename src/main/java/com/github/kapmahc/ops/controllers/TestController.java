package com.github.kapmahc.ops.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        template.convertAndSend("echo", "Hello, " + new Date().toString());
    }


    @Resource
    AmqpTemplate template;
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
}
