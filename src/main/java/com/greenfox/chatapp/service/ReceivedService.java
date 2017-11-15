package com.greenfox.chatapp.service;


import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReceivedService {

    @Autowired
    ChatMessageRepository chatMessageRepository;

    public Object receiveStatus(@RequestBody Received received) {
        StringBuilder status = new StringBuilder();
        status.append("Missing field(s): ");
        if (received.getMessage().getId() != null && received.getMessage().getText() != null && received.getMessage().getUsername() != null && received.getMessage().getTimestamp() != null) {
            chatMessageRepository.save(new ChatMessage(received.getMessage().getId(), received.getMessage().getUsername(), received.getMessage().getText(), received.getMessage().getTimestamp()));
            return new Status("ok");
        } else if (received.getMessage().getId() == null) {
            status.append("message.id");
            return new Status(status.toString());
        } else if (received.getMessage().getUsername().isEmpty() || received.getMessage().getUsername() == null) {
            status.append("message.username");
            return new Status(status.toString());
        } else if (received.getMessage().getText() == null || received.getMessage().getText().isEmpty()) {
            status.append("message.text");
            return new Status(status.toString());
        } else if (received.getMessage().getTimestamp() == null) {
            status.append("message.timestamp");
            return new Status(status.toString());
        }
        return new Status(status.toString());
    }

    /*if (chatMessage.getId() == null) {
            return new Received("Missing field(s): client.id", "");
        }
        if (chatMessage.getText() == null) {
            return new Received("Missing field(s): message.text", "");
        }
        if (chatMessage.getTimestamp() == null) {
            return new Received("Missing field(s): message.timestamp", "");
        }
        if (chatMessage.getUserName() == null) {
            return new Received("Missing field(s): message.username", "");
        }*/


}
