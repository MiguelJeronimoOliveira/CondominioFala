package com.miguel.jeronimo.CondominioFala.Entities;

import jakarta.persistence.*;

@Entity
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    //unique
    private String local;

    private int usersNumber;
}
