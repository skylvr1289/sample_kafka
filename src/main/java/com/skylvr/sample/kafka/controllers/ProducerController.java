package com.skylvr.sample.kafka.controllers;

import com.skylvr.sample.kafka.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;
    @GetMapping(path = "/producer")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("Producer is running");
    }
    @PostMapping(path = "/producer/{topic}")
    public ResponseEntity<String> publishToTopic(@PathVariable("topic") final String topic, @RequestBody String message){
        producerService.publishMessage(topic,message);
        return ResponseEntity.ok("Message Published");
    }

}
