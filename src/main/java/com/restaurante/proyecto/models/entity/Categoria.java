package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long ctg_id;
    @Column
    private String ctg_descripcion;
    @OneToMany(mappedBy = "ptl_categoria", cascade = CascadeType.ALL)
    private List<Plato> platos;

    public Categoria() {
    }

    public Categoria(String ctg_descripcion) {
        this.ctg_descripcion = ctg_descripcion;
    }

    public Long getCtg_id() {
        return ctg_id;
    }

    public void setCtg_id(Long ctg_id) {
        this.ctg_id = ctg_id;
    }

    public String getCtg_descripcion() {
        return ctg_descripcion;
    }

    public void setCtg_descripcion(String ctg_descripcion) {
        this.ctg_descripcion = ctg_descripcion;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
}
