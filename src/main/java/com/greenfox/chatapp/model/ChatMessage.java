package com.greenfox.chatapp.model;


import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChatMessage {

    @Id
    Long id;

    String userName;
    String text;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    public ChatMessage() {
    }

    public ChatMessage(String userName, String text, String timestamp) {
        this.id = randomId();
        this.userName = userName;
        this.text = text;
    }

    public Long randomId() {
        long id = ThreadLocalRandom.current().nextLong(1000000,9999999);
        return id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
