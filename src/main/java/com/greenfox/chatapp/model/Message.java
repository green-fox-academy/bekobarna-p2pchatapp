package com.greenfox.chatapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    @Id
    Long id;

    String username;
    String text;
    Timestamp timestamp;

    public Message() {
        this.id = randomId();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Message(String username, String text) {
        this.id = randomId();
        this.username = username;
        this.text = text;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Message(Long id, String username, String text, Timestamp timestamp) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.timestamp = timestamp;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
