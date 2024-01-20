package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "Usuario")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private  String email;
    private String nickname;
    private String status;
    private Date date;
    private String foto;
    @OneToMany(mappedBy = "message")
    private Set<Message> message;
    public User() {
    }

    public User(int id, String name, String password, String email, String nickname, String status, Date date, String foto) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.status = status;
        this.date = date;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getNickname(), user.getNickname()) && Objects.equals(getStatus(), user.getStatus()) && Objects.equals(getDate(), user.getDate()) && Objects.equals(getFoto(), user.getFoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getEmail(), getNickname(), getStatus(), getDate(), getFoto());
    }



}
