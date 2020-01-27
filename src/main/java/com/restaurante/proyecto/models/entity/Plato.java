package com.restaurante.proyecto.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue
    private Long ptl_id;
    @Column
    private String ptl_descripcion;
    @Column
    private Double ptl_precio;
    @ManyToOne
    @JoinColumn(name = "PTL_CATEGORIA", referencedColumnName = "ctg_id")
    private Categoria ptl_categoria;

    public Plato() {
    }

    public Plato(String ptl_descripcion, Double ptl_precio, Categoria categoria) {
        this.ptl_descripcion = ptl_descripcion;
        this.ptl_precio = ptl_precio;
        this.ptl_categoria = categoria;
    }

    public Long getPtl_id() {
        return ptl_id;
    }

    public void setPtl_id(Long ptl_id) {
        this.ptl_id = ptl_id;
    }

    public String getPtl_descripcion() {
        return ptl_descripcion;
    }

    public void setPtl_descripcion(String ptl_descripcion) {
        this.ptl_descripcion = ptl_descripcion;
    }

    public Double getPtl_precio() {
        return ptl_precio;
    }

    public void setPtl_precio(Double ptl_precio) {
        this.ptl_precio = ptl_precio;
    }

    public Categoria getPtl_categoria() {
        return ptl_categoria;
    }

    public void setPtl_categoria(Categoria ptl_categoria) {
        this.ptl_categoria = ptl_categoria;
    }
}
