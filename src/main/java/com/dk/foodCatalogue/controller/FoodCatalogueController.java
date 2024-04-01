package com.dk.foodCatalogue.controller;

import com.dk.foodCatalogue.dto.FoodCatalogueDto;
import com.dk.foodCatalogue.dto.FoodItemDto;
import com.dk.foodCatalogue.entity.FoodItem;
import com.dk.foodCatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@CrossOrigin
@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
    @Autowired
    FoodCatalogueService foodCatalogueService;


    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto foodItemAdded=foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(foodItemAdded, HttpStatus.CREATED);
    }
   @GetMapping("/fetchFoodItemAndRestById/{id}")
    public ResponseEntity<FoodCatalogueDto> fetchFoodItemAndRestList(@PathVariable Integer id){
        FoodCatalogueDto foodItemRestList=foodCatalogueService.findById(id);
        return new ResponseEntity<>(foodItemRestList, HttpStatus.OK);
    }
}
