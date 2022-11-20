package com.cursoplazi.persistance.mapper;


import com.cursoplazi.domain.Category;
import com.cursoplazi.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//es un component de tipo Spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(target = "categoryId", source = "idCategoria"),
            @Mapping(target = "category", source = "descripcion"),
            @Mapping(target = "active", source = "estado")
            })
    Category toCategory(Categoria categoria);

    //esta anotacion nos sirve para hacer la inversa a la que se hixo en la parte de arriba con la
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
    //como tenemos dentro de la clase categoria a "productos" tenemos que indicarle a este mapping nuevo que lo ignore


}
