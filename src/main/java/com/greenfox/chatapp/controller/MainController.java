package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.repository.ChatUserRepository;
import com.greenfox.chatapp.service.ChatLogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    ChatLogService chatLogService;

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Exception exception) {
        chatLogService.checkEnvironment(request, exception);
        return "index";
    }

    @GetMapping(value = "/enter")
    public String enter(HttpServletRequest request, Exception exception) {
        chatLogService.checkEnvironment(request, exception);
        return "enter";
    }

    @PostMapping(value = "/saveUser")
    public String enterUser(HttpServletRequest request, Exception exception, @RequestParam String userName) {
        chatLogService.checkEnvironment(request, exception);
        chatUserRepository.save(new ChatUser(userName));
        return "redirect:/index";
    }

}
