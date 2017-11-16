package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repository.MessageRepository;
import com.greenfox.chatapp.service.ChatService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {


    @Autowired
    ChatService chatService;

    @Autowired
    MessageRepository messagerepo;


    @CrossOrigin("*")
    @PostMapping (value = "/api/message/receive")
    public Object receiveStatus(HttpServletRequest request, Exception exception, @RequestBody Received received) {
        chatService.checkEnvironment(request, exception);
        if (chatService.checkFields(received).equals("")){
            messagerepo.save(received.getMessage());
            return "{\"status\": \"ok\"}";
        }
        else {
            return new ResponseEntity(new Status("error", "Missing field(s):" + chatService.checkFields(received)), HttpStatus.BAD_REQUEST);
        }


      // return receivedService.receiveStatus(received);
        /*return chatMessageRepository.save(new ChatMessage(received.getMessage().getId(), received.getMessage().getUsername(),
            received.getMessage().getText(), received.getMessage().getTimestamp()));*/

    }

}
