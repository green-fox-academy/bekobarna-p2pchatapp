package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.service.ChatLogService;
import com.greenfox.chatapp.service.ReceivedService;
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

    @Autowired
    ReceivedService receivedService;

    @PostMapping (value = "/api/message/receive")
    public Object receiveStatus(HttpServletRequest request, Exception exception, @RequestBody Received received) {
        chatLogService.checkEnvironment(request, exception);
      //  receivedService.receiveStatus(received);

       /* return chatMessageRepository.save(new ChatMessage(received.getMessage().getId(), received.getMessage().getUsername(),
            received.getMessage().getText(), received.getMessage().getTimestamp()));*/
        return receivedService.receiveStatus(received);
    }

}
