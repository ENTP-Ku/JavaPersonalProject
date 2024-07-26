package com.packt.cardatabase.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int years;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonManagedReference
    private Owner owner;


    // 기본 생성자
    public Car() {}

    // 생성자
    public Car(String brand, String model, int years, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.years = years;
        this.owner = owner;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return years;
    }

    public void setYear(int years) {
        this.years = years;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
