package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.service.ChatLogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {


    @Autowired
    ChatLogService chatLogService;

    @Autowired
    ChatMessageRepository chatMessageRepository;

    @PostMapping (value = "/api/message/receive")
    public Object receiveStatus(HttpServletRequest request, Exception exception, @RequestBody Received received) {
        chatLogService.checkEnvironment(request, exception);
        return chatMessageRepository.save(new ChatMessage(received.getMessage().getId(), received.getMessage().getUsername(),
            received.getMessage().getText(), received.getMessage().getTimestamp()));

    }

}
