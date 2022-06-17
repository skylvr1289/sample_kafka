package com.skylvr.sample.kafka.controllers;

import com.skylvr.sample.kafka.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping(path="/consumer")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("Consumer service is up.");
    }
    @GetMapping(path = "/consumer/orders")
    public ResponseEntity<List<String>> consumeOrders(){
        return ResponseEntity.ok(consumerService.consumeOrders());
    }
}
