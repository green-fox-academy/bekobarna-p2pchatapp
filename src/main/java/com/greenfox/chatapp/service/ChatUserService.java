package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.repository.ChatUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatUserService {


    @Autowired
    ChatUserRepository chatUserRepository;

    public ChatUserService() {
    }

    public List<ChatUser> getAllChatUser() {
        List<ChatUser> users = new ArrayList<>();
        chatUserRepository.findAll().forEach(users::add);
        return users;
    }

    public ChatUser getFirstUser() {
        return chatUserRepository.findOne(1l);
    }


    public ChatUserRepository getChatUserRepository() {
        return chatUserRepository;
    }

    public void setChatUserRepository(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    public Iterable<ChatUser> findAllUser() {
        return chatUserRepository.findAll();
    }

    public void addUser(ChatUser userka) {
        chatUserRepository.save(userka);
    }

    public ChatUser findUserById (Long id) {
        return chatUserRepository.findOne(id);
    }

    public ChatUser getNewUser() {
        return new ChatUser();
    }

    public void saveDatabase(ChatUser user) {
        chatUserRepository.save(user);
    }


}
