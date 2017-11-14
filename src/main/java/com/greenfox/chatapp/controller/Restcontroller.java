package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.service.ChatLogService;
import com.greenfox.chatapp.service.ChatUserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {

    @Autowired
    ChatLogService chatLogService;

    @Autowired
    ChatUserService chatUserService;

    @PostMapping (value = "/api/message/receive")
    public Object receive() {

        return new ChatMessage(chatUserService.getFirstUser().userName, "iui");
    }

}
