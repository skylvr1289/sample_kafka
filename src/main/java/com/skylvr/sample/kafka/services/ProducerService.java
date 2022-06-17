package com.skylvr.sample.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class ProducerService {
    private static final Logger logger =
            LoggerFactory.getLogger(ProducerService.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String topicName, String message) {

        logger.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(topicName, message);

    }
}
