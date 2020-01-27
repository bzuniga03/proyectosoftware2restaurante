package com.restaurante.proyecto.controllers.objetos;

import com.restaurante.proyecto.models.entity.Plato;

import java.util.List;

public class MenuRestaurante {

    private Long idCategoria;
    private String descripcionCategoria;
    private List<Plato> platoList;

    public MenuRestaurante() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public List<Plato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<Plato> platoList) {
        this.platoList = platoList;
    }
}
