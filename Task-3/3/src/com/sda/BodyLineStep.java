package com.sda;

public class BodyLineStep implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготовление корпуса");
        IProductPart body = new ProductPart("Body");
        return body;
    }

}