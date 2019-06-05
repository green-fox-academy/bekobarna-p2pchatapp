package com.greenfox.chatapp.service;


import com.greenfox.chatapp.model.ChatLog;
import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repository.ChatUserRepository;
import com.greenfox.chatapp.repository.MessageRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    MessageRepository messagerepo;


    public void checkEnvironment(HttpServletRequest request, Exception exception) {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            System.out.println(new ChatLog(request).toString());
        } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
            if (exception != null) {
                System.err.println(new ChatLog(request).toString());
            }
        }
    }

    public ChatUser getFirstUser() {
        return chatUserRepository.findById(1l).orElse(null);
    }

    public String checkFields(Received received){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (received.getMessage().getUsername() == null || received.getMessage().getUsername().isEmpty()){
            sb.append("message.userName");
        } if (received.getMessage().getText() == null || received.getMessage().getText().isEmpty()) {
            sb.append(", ");
            sb.append("message.text");
        } if (received.getMessage().getTimestamp() == null){
            sb.append(", ");
            sb.append("message.timestamp");
        } if (received.getMessage().getId() == null ){
            sb.append(", ");
            sb.append("message.messageId");
        }  if (received.getClient() == null || received.getClient().getId() == null  || received.getClient().getId().isEmpty()) {
            sb.append(", ");
            sb.append("client.id");
        }
        return sb.toString();
    }

    public void sendMessage (Received received) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Received> httpent = new HttpEntity<>(received);
        Status s = restTemplate.postForObject(System.getenv("CHAT_APP_PEER_ADDRESS"),httpent, Status.class);
    }
}

   /* public Status receiveStatus(@RequestBody Received received) {
        messagerepo.save(new ChatMessage(received.getMessage().getId(), received.getMessage().getUsername(), received.getMessage().getText(), new Timestamp(System.currentTimeMillis())));
        return new Status("ok");

        StringBuilder status = new StringBuilder();
        status.append("Missing field(s): ");
        if (received.getMessage().getId() != null && received.getMessage().getText() != null && received.getMessage().getUsername() != null && received.getMessage().getTimestamp() != null) {
        }
        if (received.getMessage().getId() == null) {
            status.append("message.id");
            return new Status(status.toString());
        }
        if (received.getMessage().getUsername() == null) {
            status.append("message.username");
            return new Status(status.toString());
        }
        if (received.getMessage().getText() == null) {
            status.append("message.text");
            return new Status(status.toString());
        }
        if (received.getMessage().getTimestamp() == null) {
            status.append("message.timestamp");
            return new Status(status.toString());
        }
        return new Status(status.toString());*/