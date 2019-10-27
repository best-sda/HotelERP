package com.sda;

public class DisplayLineStep implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготовление дисплея");
        IProductPart display = new ProductPart("Display");
        return display;
    }

}
