package com.cursoplazi.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId// se utiliza para cuando la llave primaria es compuesta y esta dada por otra clase
    private ComprasProductoPK id;// se crea el atributo de la clase donde fueron guardadas las llaves primarias
    private Integer cantidad;
    private Double total;
    private Boolean estado;
//esta es la realcion con la tabla compra
    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    //esta es la relacion con la tabla producto
    @ManyToOne
    @JoinColumn(name = " id_producto", insertable = false, updatable = false)
    private Producto producto;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
