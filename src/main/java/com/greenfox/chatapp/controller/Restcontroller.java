package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatLog;
import com.greenfox.chatapp.repository.ChatLogRepository;
import com.greenfox.chatapp.service.ChatLogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {

    @Autowired
    ChatLogService chatLogService;

    @Autowired
    ChatLogRepository chatLogRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String log(HttpServletRequest request, Exception exception) {
        chatLogService.checkEnvironment(request, exception);
        ChatLog log = new ChatLog(request);
        chatLogRepository.save(log);
        return log.toString();

    }

}
