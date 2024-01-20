package entities;

import jakarta.persistence.*;
import Enum.RoleUser;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "user")
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

    private RoleUser roleUser;
    public User() {
    }

    public User(int id, String name, String password, String email, String nickname, String status, Date date, String foto, Set<Message> message, RoleUser roleUser) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.status = status;
        this.date = date;
        this.foto = foto;
        this.message = message;
        this.roleUser = roleUser;
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

    public Set<Message> getMessage() {
        return message;
    }

    public void setMessage(Set<Message> message) {
        this.message = message;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(nickname, user.nickname) && Objects.equals(status, user.status) && Objects.equals(date, user.date) && Objects.equals(foto, user.foto) && Objects.equals(message, user.message) && roleUser == user.roleUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, nickname, status, date, foto, message, roleUser);
    }
}
