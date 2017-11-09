package com.greenfox.chatapp.controller;


import com.greenfox.chatapp.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    MainRepository mainRepository;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}
