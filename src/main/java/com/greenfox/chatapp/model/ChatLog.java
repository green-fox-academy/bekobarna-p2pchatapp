package com.greenfox.chatapp.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

public class ChatLog {

    String dateTime;
    String logLevel;
    String path;
    String method;
    String param;

    public ChatLog() {
    }

    public ChatLog(HttpServletRequest request) {
        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.param = request.getQueryString();
    }

    //2017-05-16 21:47:19.040 INFO Request /message POST text=apple
    @Override
    public String toString() {
        return dateTime + " " + logLevel + " " + path + " " + method + " " + param;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return param;
    }

    public void setPath(String param) {
        this.param = param;
    }

    public String getRequestData() {
        return path;
    }

    public void setRequestData(String path) {
        this.path = path;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
