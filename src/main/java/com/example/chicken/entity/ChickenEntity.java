package com.example.chicken.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="store")
public class ChickenEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int eggnumber;
}
