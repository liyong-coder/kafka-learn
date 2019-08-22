package com.example.consumerone.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: liyong
 * @date: 2019/8/19 0019 16:24
 */
@Component
@Slf4j
public class KafkaRecevier {

    @KafkaListener(topics = {"liyong"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("test-consumer-group-1--消费者---------- record =" + record);
            log.info("test-consumer-group-1--消费者------------- message =" + message);
        }
    }

}
