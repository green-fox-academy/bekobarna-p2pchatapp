package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.Client;
import com.greenfox.chatapp.model.Received;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repository.ChatUserRepository;
import com.greenfox.chatapp.repository.MessageRepository;
import com.greenfox.chatapp.service.ChatService;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    ChatService chatService;

    @Autowired
    MessageRepository messagerepo;


    @GetMapping(value = {"/", ""})
    public String index(HttpServletRequest request, Exception exception, Model model) {
        chatService.checkEnvironment(request, exception);
        if (size(chatUserRepository.findAll()) == 0) {
            return "enter";
        } else  {
            chatService.checkEnvironment(request, exception);
            model.addAttribute("user", chatService.getFirstUser());
            model.addAttribute("messages", messagerepo.findAll());
            return "index";
        }
    }

    @PostMapping(value = "/saveMessage")
    public String indexNew(HttpServletRequest request, Exception exception, @RequestParam(value = "text") String text, Model model, @ModelAttribute Message message){
        chatService.checkEnvironment(request, exception);
        model.addAttribute("message", new Message());
        message.setUsername(chatUserRepository.findById(1l).orElse(null).getUsername());
        message.setId(message.randomId());
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatService.sendMessage(new Received(message, new Client(System.getenv("CHAT_APP_UNIQUE_ID"))));
//        RestTemplate restTemplate = new RestTemplate();
//        Status status = restTemplate.postForObject("http://localhost:8080/api/message/receive", received, Status.class);
//        messagerepo.save(new Message(chatService.getFirstUser().getUsername(), text));
        return "redirect:/";
    }

    @GetMapping(value = "/enter")
    public String enter(HttpServletRequest request, Exception exception) {
        chatService.checkEnvironment(request, exception);
        return "enter";
    }

    @PostMapping(value = "/saveUser")
    public String enterUser(HttpServletRequest request, Exception exception, @RequestParam String username) {
        chatService.checkEnvironment(request, exception);
        chatUserRepository.save(new ChatUser(username));
        return "redirect:/";
    }

    @PostMapping(value = "/updateUser")
    public String updatePost(HttpServletRequest request, Exception exception, @ModelAttribute ChatUser user) {
        chatService.checkEnvironment(request, exception);
        chatUserRepository.save(user);
        return "redirect:/";
    }
}
