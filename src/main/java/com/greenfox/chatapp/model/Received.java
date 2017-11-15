package com.greenfox.chatapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Received {
    ChatMessage message;
    ChatUser client;

    public Received() {
    }

    public Received(ChatMessage message, ChatUser client) {
        this.message = message;
        this.client = client;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }

    public ChatUser getClient() {
        return client;
    }

    public void setClient(ChatUser client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Received{" +
            "message=" + message +
            ", client=" + client +
            '}';
    }
}