package com.greenfox.chatapp.repository;


import com.greenfox.chatapp.model.ChatLog;
import com.greenfox.chatapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface MainRepository extends CrudRepository<User, Long> {

}
