package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.CategoryDTO;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    CategoryDTO toCategory(Category categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Category toCategoria(CategoryDTO category);
}
