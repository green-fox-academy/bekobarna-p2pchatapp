package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatLog;
import com.greenfox.chatapp.repository.ChatLogRepository;
import com.greenfox.chatapp.service.ChatLogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    ChatLogRepository chatLogRepository;

    @Autowired
    ChatLogService chatLogService;

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Exception exception) {
        chatLogService.checkEnvironment(request, exception);
        return "index";
    }

}
