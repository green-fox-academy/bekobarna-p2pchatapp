package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
