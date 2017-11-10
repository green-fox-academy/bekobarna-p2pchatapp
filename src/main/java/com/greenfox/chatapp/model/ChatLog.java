package com.greenfox.chatapp.model;


import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;


public class ChatLog {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime dateTime;
    String info;
    String path;
    //String requestParam;


   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;*/

   // String level;



    public ChatLog() {
        this.dateTime = LocalDateTime.now();
    }

    public ChatLog(String level, String path, String info) {
        //this.level = level;
        this.path = path;
        this.info = info;
       // this.requestParam = requestParam;
        this.dateTime = LocalDateTime.now();

    }

    /*@Override
    public String toString() {
        return dateTime + " "  + " " + path + " " + info + " " ;
    }*/

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }*/

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return info;
    }

    public void setMethod(String info) {
        this.info = info;
    }

    /*public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }
*/
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
