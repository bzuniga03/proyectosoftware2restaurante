package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mesa", schema = "public", catalog = "d9te6vdvmh3khi")
public class MesaEntity {
    private int msaId;
    private String msaDescripcion;
    private String msaEstado;

    @Id
    @Column(name = "msa_id")
    public int getMsaId() {
        return msaId;
    }

    public void setMsaId(int msaId) {
        this.msaId = msaId;
    }

    @Basic
    @Column(name = "msa_descripcion")
    public String getMsaDescripcion() {
        return msaDescripcion;
    }

    public void setMsaDescripcion(String msaDescripcion) {
        this.msaDescripcion = msaDescripcion;
    }

    @Basic
    @Column(name = "msa_estado")
    public String getMsaEstado() {
        return msaEstado;
    }

    public void setMsaEstado(String msaEstado) {
        this.msaEstado = msaEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaEntity that = (MesaEntity) o;
        return msaId == that.msaId &&
                Objects.equals(msaDescripcion, that.msaDescripcion) &&
                Objects.equals(msaEstado, that.msaEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msaId, msaDescripcion, msaEstado);
    }
}
