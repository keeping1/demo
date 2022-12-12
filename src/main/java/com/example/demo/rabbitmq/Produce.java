package com.example.demo.rabbitmq;
import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.example.demo.constant.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author wangkg
 * @Date 2021/6/27 22:51
 */
@Component
@Slf4j
public class Produce {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @description: 发送消息到mq
     */
    public void sendMessage1(CanalEntry.Entry entry) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(entry);
        amqpTemplate.convertAndSend(Constant.EXCHANGE_NAME, Constant.CANAL_ROUTING_KEY,result);
        log.info("发送成功 {}");

    }


    /**
     * @description: 发送消息到mq
     */
    public void sendMessage2(HashMap<String,String> data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(data);
        amqpTemplate.convertAndSend(Constant.EXCHANGE_NAME, Constant.CANAL_ROUTING_KEY, result);
        log.info("发送成功 {}",JSON.toJSONString(data));

    }

}
