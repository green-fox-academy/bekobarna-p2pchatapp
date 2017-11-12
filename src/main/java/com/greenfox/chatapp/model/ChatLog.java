package com.greenfox.chatapp.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;


public class ChatLog {

    String dateTime;
    String logLevel;
    String requestData;
    String method;
    String path;

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;*/

    public ChatLog() {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss.SSS"));
    }

    public ChatLog(HttpServletRequest request) {
        this.path = request.getQueryString();
        this.method = request.getMethod();
        this.requestData = request.getRequestURI();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss.SSS"));
        if (request == null) {
            this.logLevel = "ERROR";
        } else {
            this.logLevel = "INFO Request";
        }
    }

    @Override
    public String toString() {
        return dateTime + " "  + logLevel + " " + requestData + " " + method + " " + path;
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
