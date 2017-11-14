package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatMessage;
import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.repository.ChatMessageRepository;
import com.greenfox.chatapp.repository.ChatUserRepository;
import com.greenfox.chatapp.service.ChatLogService;
import com.greenfox.chatapp.service.ChatUserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    ChatLogService chatLogService;

    @Autowired
    ChatUserService chatUserService;

    @Autowired
    ChatMessageRepository chatMessageRepository;


    @GetMapping(value = {"/", ""})
    public String index(HttpServletRequest request, Exception exception, Model model) {
        chatLogService.checkEnvironment(request, exception);
        if (size(chatUserRepository.findAll()) == 0) {
            return "enter";
        } else  {
            chatLogService.checkEnvironment(request, exception);
            model.addAttribute("user", chatUserService.getFirstUser());
            model.addAttribute("messages", chatMessageRepository.findAll());
           // model.addAttribute("newmessage", chatMessageRepository.save(new ChatMessage()));
            return "index";
        }
    }

    @PostMapping(value = "/saveMessage")
    public String indexNew(HttpServletRequest request, Exception exception, @ModelAttribute ChatMessage message, @RequestParam(value = "text") String text){
        chatLogService.checkEnvironment(request, exception);
        chatMessageRepository.save(new ChatMessage(chatUserService.getFirstUser().userName, text));
       // chatMessageRepository.save();
      //  chatMessageRepository.save(new ChatMessage(chatUserRepository.findOne(1l).getUserName(), message.getText()));
        return "redirect:/";
    }
    /*@GetMapping(value = "/index")
    public String index(HttpServletRequest request, Exception exception, Model model) {
        chatLogService.checkEnvironment(request, exception);
        return "index";
    }*/

    @GetMapping(value = "/enter")
    public String enter(HttpServletRequest request, Exception exception) {
        chatLogService.checkEnvironment(request, exception);
        return "enter";
    }

    @PostMapping(value = "/saveUser")
    public String enterUser(HttpServletRequest request, Exception exception, @RequestParam String userName) {
        chatLogService.checkEnvironment(request, exception);
        chatUserRepository.save(new ChatUser(userName));
        return "redirect:/";
    }

   /* @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Exception exception, Model model) {
        chatLogService.checkEnvironment(request, exception);
        model.addAttribute("user", chatUserRepository.findOne(1l));
        return "index";
    }*/

    @PostMapping(value = "/updateUser")
    public String updatePost(HttpServletRequest request, Exception exception, @ModelAttribute ChatUser user) {
        chatLogService.checkEnvironment(request, exception);
        chatUserRepository.save(user);
        return "redirect:/";
    }
}
