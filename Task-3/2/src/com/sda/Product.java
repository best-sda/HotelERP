package com.sda;

public class Product {
    private String name;
    private float weight;
    private int takesCells;

    public Product(String name, float weight, int takesCells) {
        this.name = name;
        this.weight = weight;
        this.takesCells = takesCells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getTakesCells() {
        return takesCells;
    }

    public void setTakesCells(int takesCells) {
        this.takesCells = takesCells;
    }

}