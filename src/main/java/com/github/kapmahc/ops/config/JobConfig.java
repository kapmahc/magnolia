package com.github.kapmahc.ops.config;

import com.github.kapmahc.ops.jobs.TaskReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by flamen on 16-12-15.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class JobConfig {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("tasks"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(TaskReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
