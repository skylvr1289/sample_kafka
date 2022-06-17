package com.skylvr.sample.kafka.services;

import com.skylvr.sample.kafka.config.KafkaConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    KafkaConsumerConfig consumerConfig;
    public KafkaConsumer<Integer, String> ordersConsumer;

    public ConsumerService( KafkaConsumerConfig consumerConfig){
        this.ordersConsumer = consumerConfig.getOrdersConsumer();
    }
    public List<String> consumeOrders() {
        logger.info("starting message consumption for topic: {}", ordersConsumer.subscription());
        ConsumerRecords<Integer, String> records = consumerConfig.getOrdersConsumer().poll(1000);
        List<String> response = new ArrayList<>();
        for (ConsumerRecord<Integer, String> record : records) {
            logger.info("Received message: ("  + record.value() + ") at offset " + record.offset());
            response.add(record.value());
        }
        return response;
    }
}
