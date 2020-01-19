package com.restaurante.proyecto.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public
class Greeting {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String message;
    @Column
    private Double price;

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public Greeting(String message, Double price) {
        this.message = message;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

