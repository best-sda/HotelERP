package com.sda;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    public Warehouse(int cellsInStock) {
        this.cellsInStock = cellsInStock;
    }

    private int cellsInStock;
    private List<Product> productList = new ArrayList<Product>();

    void addProduct (Product product) {
        if (cellsInStock - getCellsAllProducts() < product.getTakesCells()) {
            System.out.println("Сори, товар не влезает");
        } else {
            productList.add(product);
        }
    }

    int getWeightAllProducts (){
       int i=0;
        for (Product product : productList) {
            i += product.getWeight();
        }
        return i;
    }
    int getCellsAllProducts(){
        int i=0;
        for (Product product : productList) {
            i += product.getTakesCells();
        }
        return i;
    }
    int getProductCount(){
        return productList.size();
    }
}
