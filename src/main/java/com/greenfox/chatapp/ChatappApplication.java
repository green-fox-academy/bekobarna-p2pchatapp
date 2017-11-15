package com.greenfox.chatapp;


import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChatappApplication implements CommandLineRunner{

	@Autowired
	ChatUserRepository chatUserRepository;

	@Autowired
	ChatMessageRepository chatMessageRepository;


	public static void main(String[] args) {
		/*RestTemplate restTemplate = new RestTemplate();
		Received received = restTemplate.postForObject("http://localhost:8080/api/message/receive", new Received(), Received.class);*/
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Received received = restTemplate.postForObject("http://localhost:8080/api/message/receive", new Received(), Received.class);
		};
	}*/
}
