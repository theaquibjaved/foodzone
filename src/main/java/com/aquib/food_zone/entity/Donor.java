package com.aquib.food_zone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "donors")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;
    public String city;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
