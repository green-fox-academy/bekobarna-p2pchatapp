package com.greenfox.chatapp.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChatMessage {

    @Id
    Long id;

    String userName;
    String text;
    String timestamp;

    public ChatMessage() {
        this.id = randomId();
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    public ChatMessage(String userName, String text) {
        this.id = randomId();
        this.userName = userName;
        this.text = text;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    public Long randomId() {
        long id = ThreadLocalRandom.current().nextLong(1000000,9999999);
        return id;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = randomId();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
