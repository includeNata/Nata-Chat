package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Mensagem")
public class Message {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    private String message;
    private Date date;

    public Message() {
    }

    public Message(int id, User user, String message, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
