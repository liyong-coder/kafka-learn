package com.example.providerone.provider;

import com.example.providerone.beans.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: liyong
 * @date: 2019/8/19 0019 16:24
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(String name) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(name);
        message.setSendTime(new Date());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("tibmas", gson.toJson(message));
    }
}
