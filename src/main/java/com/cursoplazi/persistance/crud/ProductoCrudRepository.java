package com.cursoplazi.persistance.crud;

import com.cursoplazi.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//le pasamos la tabla y el tipo de dato de su id
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer > {

    List<Producto> findByidCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
