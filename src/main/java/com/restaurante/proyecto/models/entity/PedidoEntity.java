package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pedido", schema = "public", catalog = "d9te6vdvmh3khi")
public class PedidoEntity {
    private int pddId;
    private String pddComentario;
    private MesaEntity mesaByPddMesa;
    private String pddEstado;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pdd_id")
    public int getPddId() {
        return pddId;
    }

    public void setPddId(int pddId) {
        this.pddId = pddId;
    }

    @Basic
    @Column(name = "pdd_comentario")
    public String getPddComentario() {
        return pddComentario;
    }

    public void setPddComentario(String pddComentario) {
        this.pddComentario = pddComentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEntity that = (PedidoEntity) o;
        return pddId == that.pddId &&
                Objects.equals(pddComentario, that.pddComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pddId, pddComentario);
    }

    @ManyToOne
    @JoinColumn(name = "pdd_mesa", referencedColumnName = "msa_id")
    public MesaEntity getMesaByPddMesa() {
        return mesaByPddMesa;
    }

    public void setMesaByPddMesa(MesaEntity mesaByPddMesa) {
        this.mesaByPddMesa = mesaByPddMesa;
    }

    @Basic
    @Column(name = "pdd_estado")
    public String getPddEstado() {
        return pddEstado;
    }

    public void setPddEstado(String pddEstado) {
        this.pddEstado = pddEstado;
    }
}
