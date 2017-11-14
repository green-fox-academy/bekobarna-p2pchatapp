package com.greenfox.chatapp.model;

public class Received {
    ChatMessage message;
    ChatUser client;

    public Received() {
    }

    public Received(ChatMessage message, ChatUser client) {
        this.message = message;
        this.client = client;
    }

    /*@Override
    public String toString() {
        return message.getText() + client.getUserName();
    }*/

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
}