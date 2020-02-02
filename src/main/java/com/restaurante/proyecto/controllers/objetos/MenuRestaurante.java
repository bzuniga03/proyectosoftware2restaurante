package com.restaurante.proyecto.controllers.objetos;

import java.util.List;

public class MenuRestaurante {

    private Long idCategoria;
    private String descripcionCategoria;
    private List<ObjetoPlato> platoList;

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

    public List<ObjetoPlato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<ObjetoPlato> platoList) {
        this.platoList = platoList;
    }
}
