package com.sda;

public class BodyLineStep implements ILineStep {

    @Override
    public Body buildProductPart() {
        Body body = new Body("black");
        return body;
    }

}
