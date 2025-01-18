package com.miguel.jeronimo.CondominioFala.Entities;

import com.miguel.jeronimo.CondominioFala.DTOs.PostRequest;
import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tittle;

    private String text;

    private int likes;

    private int dislikes;

    private boolean deleted;

    private int reports;

   // @ForeignKey
    private long condominioID;

    public Post(PostRequest request) {
    }
}
