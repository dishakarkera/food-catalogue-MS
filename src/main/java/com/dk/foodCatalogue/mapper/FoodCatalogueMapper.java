package com.dk.foodCatalogue.mapper;

import com.dk.foodCatalogue.dto.FoodItemDto;
import com.dk.foodCatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodCatalogueMapper {
    FoodCatalogueMapper INSTANCE= Mappers.getMapper(FoodCatalogueMapper.class);

    FoodItem mapFoodDtoToFoodItem(FoodItemDto foodItemDto);
    FoodItemDto mapFoodItemToFoodDto(FoodItem foodItem);
}
