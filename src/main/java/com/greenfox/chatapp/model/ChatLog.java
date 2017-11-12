package com.greenfox.chatapp.model;


import java.time.LocalDateTime;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;


public class ChatLog {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime dateTime;
    String method;
    String path;
    String requestData;
    String logLevel;


    private final static Logger LOGGER = Logger.getLogger(ChatLog.class.getName());




   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;*/

    public ChatLog() {
        this.dateTime = LocalDateTime.now();
    }

    public ChatLog(HttpServletRequest request) {
        this.path = request.getContextPath();
        this.method = request.getMethod();
        this.requestData = request.getRequestURI() + request.getQueryString();
        this.dateTime = LocalDateTime.now();
        if (request == null) {
            this.logLevel = "ERROR";
        } else {
            this.logLevel = "INFO";
        }
    }

    @Override
    public String toString() {
        return dateTime + " "  + logLevel + " " + path + " " + method + " " + requestData ;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = LocalDateTime.now();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
