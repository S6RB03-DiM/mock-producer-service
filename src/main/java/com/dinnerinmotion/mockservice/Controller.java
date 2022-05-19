package com.dinnerinmotion.mockservice;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/demo")
public class Controller {
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(path = "/{msg}")
    public void send(@PathVariable String msg) {
        this.kafkaTemplate.send("mockTopic", msg);
        System.out.println("Sent sample message [" + msg + "] to " + "mockTopic");
    }
}
