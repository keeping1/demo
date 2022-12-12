package com.example.demo.rabbitmq;

import com.example.demo.constant.Constant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wangkg
 * @Date 2021/6/27 22:49
 */
@Component
public class TopicConfig {
    @Bean
    public Queue topicOpenQueue() {
        return new Queue(Constant.TOPIC_CANAL_ORDER_QUEUE);
    }

    @Bean
    public Queue topicFlumeQueue() {
        return new Queue(Constant.TOPIC_CANAL_FREZE_QUEUE);
    }


    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(Constant.EXCHANGE_NAME);
    }


    @Bean
    Binding bindingExchangeOpen(Queue topicOpenQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicOpenQueue).to(topicExchange).with(Constant.CANAL_ROUTING_KEY);

    }

    @Bean
    Binding bindingExchangeFlume(Queue topicFlumeQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicFlumeQueue).to(topicExchange).with(Constant.CANAL_FLUME_ROUTING_KEY);

    }
}
