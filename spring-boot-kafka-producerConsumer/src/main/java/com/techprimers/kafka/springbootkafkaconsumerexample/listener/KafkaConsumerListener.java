package com.techprimers.kafka.springbootkafkaconsumerexample.listener;

import com.techprimers.kafka.springbootkafkaconsumerexample.model.User;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("kafka")
public class KafkaConsumerListener {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

	 
    static List<String> message =new ArrayList<String>();
	
	@KafkaListener(topics = "Kafka_Example_json", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
	    

        logger.debug("Consumed JSON Message: " + user);
        message.add(user.toString());
    }
	
	@GetMapping("/subscribe/")
	public List<String> subscribe() {

		
		return message;
	}
    
   
}
