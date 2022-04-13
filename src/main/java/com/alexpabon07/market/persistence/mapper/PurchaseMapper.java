package com.alexpabon07.market.persistence.mapper;

import com.alexpabon07.market.domain.Purchase;
import com.alexpabon07.market.persistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idBuy", target = "purchaseId"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(Buy buy);

    List<Purchase> toPurchases(List<Buy> buyList);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Buy toBuy(Purchase purchase);
}
