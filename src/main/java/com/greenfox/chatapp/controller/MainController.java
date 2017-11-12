package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatLog;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        System.out.println(new ChatLog(request).toString());
        return "index";
    }

}
