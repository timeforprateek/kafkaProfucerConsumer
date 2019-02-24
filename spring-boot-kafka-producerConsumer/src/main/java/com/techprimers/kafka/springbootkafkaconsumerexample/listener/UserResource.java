package com.techprimers.kafka.springbootkafkaconsumerexample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.kafka.springbootkafkaconsumerexample.model.User;


@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    private static final String TOPIC = "Kafka_Example_json";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
    	logger.debug("Publishing Starts");
        kafkaTemplate.send(TOPIC, new User(name, "Technology"));
        kafkaTemplate.send(TOPIC, new User(name+1, "Technology"));
        kafkaTemplate.send(TOPIC, new User(name+2, "Technology"));
        kafkaTemplate.send(TOPIC, new User(name+3, "Technology"));
        logger.debug("Published successfully");
        return "Published successfully";
    }
}
