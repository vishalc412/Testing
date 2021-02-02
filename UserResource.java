package com.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	private static final String TOPIC ="topic_kafka";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") String name) {
		System.out.println(name+"   "+TOPIC);
		kafkaTemplate.send(TOPIC,new User(name,"Tecnology",12000L));
		return "published successfully";
	}
	

}
