package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {


}
