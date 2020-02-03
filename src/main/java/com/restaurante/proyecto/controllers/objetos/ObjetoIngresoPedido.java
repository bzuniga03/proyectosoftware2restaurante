package com.restaurante.proyecto.controllers.objetos;

import java.util.List;

public class ObjetoIngresoPedido {

    private int mesa;
    private Double total;
    private String comentarioPedido;
    private List<detallePlato> platos;

    public ObjetoIngresoPedido() {
    }

    public ObjetoIngresoPedido(int mesa, Double total, String comentarioPedido, List<detallePlato> platos) {
        this.mesa = mesa;
        this.total = total;
        this.comentarioPedido = comentarioPedido;
        this.platos = platos;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getComentarioPedido() {
        return comentarioPedido;
    }

    public void setComentarioPedido(String comentarioPedido) {
        this.comentarioPedido = comentarioPedido;
    }

    public List<detallePlato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<detallePlato> platos) {
        this.platos = platos;
    }

    public static class detallePlato {
        private int id;
        private String descripcion;

        public detallePlato() {
        }

        public detallePlato(int id, String descripcion) {
            this.id = id;
            this.descripcion = descripcion;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
