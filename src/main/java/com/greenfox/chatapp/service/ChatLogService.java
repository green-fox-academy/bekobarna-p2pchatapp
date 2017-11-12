package com.greenfox.chatapp.service;


import com.greenfox.chatapp.model.ChatLog;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class ChatLogService {

    public void checkEnvironment(HttpServletRequest request, Exception exception) {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            System.out.println(new ChatLog(request).toString());
        } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
            if (exception != null) {
                System.err.println(new ChatLog(request).toString());
            }
        }
    }

}
