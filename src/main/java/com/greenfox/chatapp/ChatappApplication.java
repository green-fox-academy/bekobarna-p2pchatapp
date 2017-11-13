package com.greenfox.chatapp;


import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication implements CommandLineRunner{

	@Autowired
	ChatUserRepository chatUserRepository;

	@Autowired
	ChatMessageRepository chatMessageRepository;


	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
