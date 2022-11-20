package com.cursoplazi.persistance;

import com.cursoplazi.domain.Product;
import com.cursoplazi.domain.repository.ProductRepository;
import com.cursoplazi.persistance.crud.ProductoCrudRepository;
import com.cursoplazi.persistance.entity.Producto;
import com.cursoplazi.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// como esta clase esta interactuando con la base de datos tiene que llevar la anotacion
// la anotacion repository, con ella le indicamos que la clase esta interactuando con la base de datos
@Repository
public class ProductoRepository implements ProductRepository {
    //con la anotacion autowired, le estamos diciendo a spring que el mismo inicialice
    // esos objetos o le cedemos el control a spring para que los inicialice
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    //atributo de tipo de la interface productocrudrepository
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByidCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos  = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    @Override
    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int productid){
        productoCrudRepository.deleteById(productid);
    }







}
