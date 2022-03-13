package com.alexpabon07.market.persistence.mapper;

import com.alexpabon07.market.domain.CategoryD;
import com.alexpabon07.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "nameCategory"),
            @Mapping(source = "status", target = "active")
    })
    CategoryD toCategoryD(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryD categoryD);
}
