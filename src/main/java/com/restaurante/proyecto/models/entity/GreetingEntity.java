package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "greeting", schema = "public", catalog = "d9te6vdvmh3khi")
public class GreetingEntity {
    private long id;
    private String message;
    private Double price;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreetingEntity that = (GreetingEntity) o;
        return id == that.id &&
                Objects.equals(message, that.message) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, price);
    }
}
