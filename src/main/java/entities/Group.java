package entities;

import java.util.Date;
import java.util.Objects;

public class Group {
    private int id;
    private String name;
    private String foto;
    private String decricao;
    private Date date;

    public Group() {
    }

    public Group(int id, String name, String foto, String decricao, Date date) {
        this.id = id;
        this.name = name;
        this.foto = foto;
        this.decricao = decricao;
        this.date = date;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
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
        if (!(o instanceof Group group)) return false;
        return getId() == group.getId() && Objects.equals(getName(), group.getName()) && Objects.equals(getFoto(), group.getFoto()) && Objects.equals(getDecricao(), group.getDecricao()) && Objects.equals(getDate(), group.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFoto(), getDecricao(), getDate());
    }
}
