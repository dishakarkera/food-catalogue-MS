package com.dk.foodCatalogue.dto;

import com.dk.foodCatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatalogueDto {
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
