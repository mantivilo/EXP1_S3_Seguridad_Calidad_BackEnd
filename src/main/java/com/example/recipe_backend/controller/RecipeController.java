package com.example.recipe_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @GetMapping("/list")
    public List<Map<String, String>> getRecipes() {
        // Sample list of recipes
        return Arrays.asList(
            Map.of("nombre", "Spaghetti Carbonara", "dificultad", "Media"),
            Map.of("nombre", "Tacos", "dificultad", "Baja"),
            Map.of("nombre", "Beef Wellington", "dificultad", "Alta")
        );
    }
}
