package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrderDetail;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.service.FoodService;
import io.github.koha11.pizza_store_pos.service.FoodTypeService;
import io.github.koha11.pizza_store_pos.service.OrderDetailService;
import io.github.koha11.pizza_store_pos.service.VariantService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderDetailMapper {
    @Autowired
    protected FoodService foodService;

    @Autowired
    protected FoodTypeService foodTypeService;

    @Autowired
    protected VariantService variantService;

    @Autowired
    protected OrderDetailService orderDetailService;

    @Mapping(source = "foodId", target = "foodName", qualifiedByName = "getFoodName")
    @Mapping(source = "foodId", target = "foodImage", qualifiedByName = "getFoodImage")
    @Mapping(source = "foodId", target = "price", qualifiedByName = "getFoodPrice")
    @Mapping(source = "variantId", target = "variantName", qualifiedByName = "getVariantName")
    @Mapping(source = "foodId", target = "foodTypeName", qualifiedByName = "getFoodTypeName")
    @Mapping(target = "actualPrice",  expression = "java(orderDetailService.calcActualPrice(orderDetail.getFoodId(), orderDetail.getAmount(), orderDetail.getVariantId()))")
    public abstract OnTableOrderDetail orderDetailToDTO(OrderDetail orderDetail);
    public abstract OrderDetail DTOToOrderDetail(OnTableOrderDetail onTableOrder);

    @Named("getFoodName")
    protected String getFoodName(String foodId) {
        Food food = foodService.getOne(foodId);
        return food != null ? food.getFoodName() : "";
    }

    @Named("getFoodImage")
    protected String getFoodImage(String foodId) {
        Food food = foodService.getOne(foodId);
        return food != null ? food.getFoodImage() : "";
    }
    @Named("getFoodTypeName")
    protected String getFoodTypeName(String foodId) {
        Food food = foodService.getOne(foodId);
        FoodType foodType = foodTypeService.getOne(food.getFoodTypeId());
        return foodType != null ? foodType.getFoodTypeName() : "";

    }
    @Named("getFoodPrice")
    protected int getFoodPrice(String foodId) {
        Food food = foodService.getOne(foodId);
        return food.getPrice();
    }

    @Named("getVariantName")
    protected String getVariantName(String variantId) {
        if(variantId == null || variantId.isEmpty())
            return null;

        Variant variant = variantService.getOne(variantId);
        return variant != null ? variant.getVariantName() : "";
    }
}
