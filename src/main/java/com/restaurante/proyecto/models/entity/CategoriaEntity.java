package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria", schema = "public", catalog = "d9te6vdvmh3khi")
public class CategoriaEntity {
    private long ctgId;
    private String ctgDescripcion;

    @Id
    @Column(name = "ctg_id")
    public long getCtgId() {
        return ctgId;
    }

    public void setCtgId(long ctgId) {
        this.ctgId = ctgId;
    }

    @Basic
    @Column(name = "ctg_descripcion")
    public String getCtgDescripcion() {
        return ctgDescripcion;
    }

    public void setCtgDescripcion(String ctgDescripcion) {
        this.ctgDescripcion = ctgDescripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return ctgId == that.ctgId &&
                Objects.equals(ctgDescripcion, that.ctgDescripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctgId, ctgDescripcion);
    }
}
