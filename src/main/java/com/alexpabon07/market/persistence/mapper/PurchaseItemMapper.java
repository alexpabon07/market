package com.alexpabon07.market.persistence.mapper;

import com.alexpabon07.market.domain.PurchaseItem;
import com.alexpabon07.market.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "idProduct"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(BuyProduct buyProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true)
    })
    BuyProduct toBuyProduct(PurchaseItem purchaseItem);
}
