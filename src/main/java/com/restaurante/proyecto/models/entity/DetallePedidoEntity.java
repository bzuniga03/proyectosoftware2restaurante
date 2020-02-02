package com.restaurante.proyecto.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detalle_pedido", schema = "public", catalog = "d9te6vdvmh3khi")
public class DetallePedidoEntity {
    private int dpdId;
    private PedidoEntity pedidoEntity;
    private PlatoEntity platoEntity;

    @Id
    @Column(name = "dpd_id")
    public int getDpdId() {
        return dpdId;
    }

    public void setDpdId(int dpdId) {
        this.dpdId = dpdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedidoEntity that = (DetallePedidoEntity) o;
        return dpdId == that.dpdId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dpdId);
    }

    @ManyToOne
    @JoinColumn(name = "dpd_pedido", referencedColumnName = "pdd_id")
    public PedidoEntity getPedidoEntity() {
        return pedidoEntity;
    }

    public void setPedidoEntity(PedidoEntity pedidoEntity) {
        this.pedidoEntity = pedidoEntity;
    }

    @ManyToOne
    @JoinColumn(name = "dpd_plato", referencedColumnName = "ptl_id")
    public PlatoEntity getPlatoEntity() {
        return platoEntity;
    }

    public void setPlatoEntity(PlatoEntity platoEntity) {
        this.platoEntity = platoEntity;
    }
}
