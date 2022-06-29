package com.example.fishshop1.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "description")
@Data
public class DiscModel {
    @Id
    long id = 1;

    @Column(name = "disc")
    String disc;
}
