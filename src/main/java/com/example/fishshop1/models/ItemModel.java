package com.example.fishshop1.models;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title")
    String title;

    @Column(name = "short_disc")
    String disc;

    @Column(name = "photo_url")
    String url;
}
