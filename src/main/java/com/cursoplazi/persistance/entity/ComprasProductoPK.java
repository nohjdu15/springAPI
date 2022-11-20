package com.cursoplazi.persistance.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//embedable porque la vamos a embeber dentro de la clase comprasproducto
@Embeddable
public class ComprasProductoPK implements Serializable {
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIcProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
