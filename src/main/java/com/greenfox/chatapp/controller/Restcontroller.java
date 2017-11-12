package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.model.ChatLog;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log(HttpServletRequest request) {
        return new ChatLog(request).toString();
    }

}
