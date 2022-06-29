package com.example.fishshop1.models;

import com.example.fishshop1.enums.TypeEnum;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

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

    @Column(name = "if_actual")
    boolean ifActual;

    @Column(name = "type")
    @Enumerated
    TypeEnum typeEnum;

}
