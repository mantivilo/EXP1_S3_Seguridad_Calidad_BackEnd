package com.example.recipe_backend.controller;

import com.example.recipe_backend.repository.RecipeRepository;
import com.example.recipe_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.recipe_backend.model.Recipe;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private JwtUtil jwtUtil; // Inject JwtUtil

    // Public endpoint for the list of recipes (e.g., homepage)
    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    // Private endpoint for recipe details (requires authentication)
    @GetMapping("/details")
    public List<Recipe> getAllRecipeDetails(@RequestHeader HttpHeaders headers) {
        String authorizationHeader = headers.getFirst("Authorization");
        System.out.println("Authorization Header Received: " + authorizationHeader);
    
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization header missing or invalid.");
        }
    
        String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
        if (!jwtUtil.validateToken(token)) {
            throw new RuntimeException("Invalid or expired token.");
        }
    
        System.out.println("Token validated successfully. Fetching recipes...");
        List<Recipe> recipes = recipeRepository.findAll();
        System.out.println("Recipes returned from database: " + recipes);
    
        return recipes;
    }

}
