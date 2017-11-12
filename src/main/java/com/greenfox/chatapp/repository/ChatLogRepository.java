package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatLog;
import org.springframework.data.repository.CrudRepository;

public interface ChatLogRepository extends CrudRepository<ChatLog, Long> {

}
