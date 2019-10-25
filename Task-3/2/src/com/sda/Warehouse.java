package com.sda;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private int cellsInStock;
    private List <Product> productList = new ArrayList <Product>();

    public Warehouse(int cellsInStock) {
        this.cellsInStock = cellsInStock;
    }

    public void addProduct(Product product) {
        if (cellsInStock - getCellsAllProducts() < product.getTakesCells()) {
            System.out.println("Сори, товар не влезает");
        } else {
            productList.add(product);
        }
    }

    public int getWeightAllProducts() {
        int i = 0;
        for (Product product : productList) {
            i += product.getWeight();
        }
        return i;
    }

    public int getCellsAllProducts() {
        int i = 0;
        for (Product product : productList) {
            i += product.getTakesCells();
        }
        return i;
    }

    public int getProductCount() {
        return productList.size();
    }

}