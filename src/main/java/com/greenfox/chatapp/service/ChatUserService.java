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

    public ChatUser getFirstUser() {
        return chatUserRepository.findOne(1l);
    }

}
