package com.example.fishshop1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "wanted_item")
    String item;

    @Column(name = "contact")
    String contact;

    @Column(name = "actual")
    boolean actual;
}
