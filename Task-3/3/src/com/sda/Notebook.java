package com.sda;

public class Notebook implements IProduct {

    private IProductPart body;
    private IProductPart matherBoard;
    private IProductPart display;

    @Override
    public void installFirstPart(IProductPart productPart) {

        System.out.println("Установка материнской платы");
        this.matherBoard = productPart;

    }

    @Override
    public void installSecondPart(IProductPart productPart) {

        System.out.println("Установка дисплея");
        this.display = productPart;

    }

    @Override
    public void installThirdPart(IProductPart productPart) {

        System.out.println("Установка корпуса");
        this.body = productPart;

    }

    public Notebook() {
    }

}