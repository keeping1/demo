package com.example.demo.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author wangkg
 * @Date 2021/6/28 11:40
 */
@Slf4j
@Component
public class RabbitMqConsumer {
    @RabbitHandler
    @RabbitListener(queues = "canal.queue")
    public void pushMessageHandler(Message message, Channel channel) throws IOException {
        log.info("===mq开始消费：===");
        log.info("===收到的消息：{}", message.getBody());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
