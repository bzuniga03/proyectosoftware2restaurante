package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plato", schema = "public", catalog = "d9te6vdvmh3khi")
public class PlatoEntity {
    private long ptlId;
    private String ptlDescripcion;
    private Double ptlPrecio;
    private CategoriaEntity categoriaByPtlCategoria;

    @Id
    @Column(name = "ptl_id")
    public long getPtlId() {
        return ptlId;
    }

    public void setPtlId(long ptlId) {
        this.ptlId = ptlId;
    }

    @Basic
    @Column(name = "ptl_descripcion")
    public String getPtlDescripcion() {
        return ptlDescripcion;
    }

    public void setPtlDescripcion(String ptlDescripcion) {
        this.ptlDescripcion = ptlDescripcion;
    }

    @Basic
    @Column(name = "ptl_precio")
    public Double getPtlPrecio() {
        return ptlPrecio;
    }

    public void setPtlPrecio(Double ptlPrecio) {
        this.ptlPrecio = ptlPrecio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoEntity that = (PlatoEntity) o;
        return ptlId == that.ptlId &&
                Objects.equals(ptlDescripcion, that.ptlDescripcion) &&
                Objects.equals(ptlPrecio, that.ptlPrecio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ptlId, ptlDescripcion, ptlPrecio);
    }

    @ManyToOne
    @JoinColumn(name = "ptl_categoria", referencedColumnName = "ctg_id")
    public CategoriaEntity getCategoriaByPtlCategoria() {
        return categoriaByPtlCategoria;
    }

    public void setCategoriaByPtlCategoria(CategoriaEntity categoriaByPtlCategoria) {
        this.categoriaByPtlCategoria = categoriaByPtlCategoria;
    }
}
