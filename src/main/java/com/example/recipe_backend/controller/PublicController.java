package com.example.recipe_backend.controller;

import com.example.recipe_backend.model.Recipe;
import com.example.recipe_backend.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final RecipeRepository recipeRepository;

    public PublicController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/recipes/search")
    public List<Recipe> searchRecipes(@RequestParam String name) {
        return recipeRepository.findByNameContaining(name);
    }
}
