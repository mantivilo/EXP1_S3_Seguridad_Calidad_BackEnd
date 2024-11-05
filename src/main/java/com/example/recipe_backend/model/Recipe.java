package com.example.recipe_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // Type of cuisine (e.g., Italian, Mexican, etc.)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredients; // Ingredients required for the recipe

    @Column(nullable = false)
    private String country; // Country of origin

    @Column(nullable = false)
    private String difficulty; // Difficulty level (e.g., Easy, Medium, Hard)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String instructions; // Step-by-step instructions

    @Column(nullable = true)
    private String imageUrl; // URL for the recipe image (optional)

    // Default constructor
    public Recipe() {
    }

    // Constructor with all fields
    public Recipe(String name, String type, String ingredients, String country, String difficulty, String instructions, String imageUrl) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.country = country;
        this.difficulty = difficulty;
        this.instructions = instructions;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Optional: Override toString() method for better logging/debugging
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", country='" + country + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", instructions='" + instructions + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
