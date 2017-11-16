package com.greenfox.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String username;

    public ChatUser() {
    }

    public ChatUser(String username) {
        this.username = username;
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
}
