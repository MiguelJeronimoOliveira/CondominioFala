package com.miguel.jeronimo.CondominioFala.Entities;

import com.miguel.jeronimo.CondominioFala.DTOS.CondominioRequest;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Users> residents;

    private String name;

    //unique
    private String local;

    private int usersNumber;

    public Condominio condominioDTO(CondominioRequest request) {
        Condominio condominio = new Condominio();
        condominio.name = request.name();
        condominio.local = request.local();
        return condominio;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(int usersNumber) {
        this.usersNumber = usersNumber;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Users> getResidents() {
        return residents;
    }

    public void setResidents(List<Users> residents) {
        this.residents = residents;
    }
}
