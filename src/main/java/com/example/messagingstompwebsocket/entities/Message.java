package com.example.messagingstompwebsocket.entities;

import javax.xml.crypto.Data;
import java.util.Objects;

public class Message {
    private int id;
    private User user;
    private String message;
    private Data date;

    public Message() {
    }

    public Message(int id, User user, String message, Data date) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message message1)) return false;
        return getId() == message1.getId() && Objects.equals(getUser(), message1.getUser()) && Objects.equals(getMessage(), message1.getMessage()) && Objects.equals(getDate(), message1.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getMessage(), getDate());
    }
}
