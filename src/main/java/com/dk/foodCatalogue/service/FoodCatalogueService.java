package com.dk.foodCatalogue.service;

import com.dk.foodCatalogue.dto.FoodCatalogueDto;
import com.dk.foodCatalogue.dto.FoodItemDto;
import com.dk.foodCatalogue.dto.Restaurant;
import com.dk.foodCatalogue.entity.FoodItem;
import com.dk.foodCatalogue.mapper.FoodCatalogueMapper;
import com.dk.foodCatalogue.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {
    @Autowired
    FoodItemRepo foodItemRepo;
    @Autowired
    RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem saveItem = foodItemRepo.save(FoodCatalogueMapper.INSTANCE.mapFoodDtoToFoodItem(foodItemDto));
    return FoodCatalogueMapper.INSTANCE.mapFoodItemToFoodDto(saveItem);
    }

    public FoodCatalogueDto findById(Integer id) {
        //food list
        //restuarnt det from restaurant microservice
       List<FoodItem> foodItemList= fetchFoodItemList(id);
        Restaurant restaurant=fetchRestaurantDetails(id);


        return createCataloguePage(foodItemList, restaurant);
    }

    private Restaurant fetchRestaurantDetails(Integer id) {
        return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/"+id,Restaurant.class);


    }

    private List<FoodItem> fetchFoodItemList(Integer id) {
        List<FoodItem> foodItemList=foodItemRepo.findByRestaurantId(id);
        return foodItemList;
    }

    private FoodCatalogueDto createCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCatalogueDto foodCatalogueDto=new FoodCatalogueDto();
        foodCatalogueDto.setFoodItemList(foodItemList);
        foodCatalogueDto.setRestaurant(restaurant);
        return foodCatalogueDto;

    }
}
