package com.sda;

public class BodyLineStep implements ILineStep {

    @Override
    public Body buildProductPart() {
        System.out.println("Изготовление корпуса");
        Body body = new Body("black");
        return body;
    }

}
