package com.sda;

public class Main {

    public static void main(String[] args) {
        Warehouse stock = new Warehouse(9);
        stock.addProduct(new Product("TV", 14, 4));
        stock.addProduct(new Product("PC", 6, 2));
        stock.addProduct(new Product("Monitor", 4, 3));
        System.out.println("На складе " + stock.getProductCount() + " товаров, общим весом " + stock.getWeightAllProducts());
    }

}
