package com.restaurante.proyecto.controllers.objetos;

public class ObjetoPedido {

    private Integer idPedido;
    private String comentarioPedido;
    private Long mesa;
    private String platos;
    private String estado;

    public ObjetoPedido() {
    }

    public ObjetoPedido(Integer idPedido, String comentarioPedido, Long mesa, String platos, String estado) {
        this.idPedido = idPedido;
        this.comentarioPedido = comentarioPedido;
        this.mesa = mesa;
        this.platos = platos;
        this.estado = estado;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getComentarioPedido() {
        return comentarioPedido;
    }

    public void setComentarioPedido(String comentarioPedido) {
        this.comentarioPedido = comentarioPedido;
    }

    public Long getMesa() {
        return mesa;
    }

    public void setMesa(Long mesa) {
        this.mesa = mesa;
    }

    public String getPlatos() {
        return platos;
    }

    public void setPlatos(String platos) {
        this.platos = platos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
