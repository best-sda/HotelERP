package com.sda;

public class Notebook implements IProduct {

   private Body body;
   private MatherBoard matherBoard;
   private Display display;

    @Override
    public void installFirstPart(IProductPart productPart) {

        System.out.println("Установка материнской платы");
        this.matherBoard = (MatherBoard) productPart;

    }

    @Override
    public void installSecondPart(IProductPart productPart) {

        System.out.println("Установка дисплея");
        this.display = (Display) productPart;

    }

    @Override
    public void installThirdPart(IProductPart productPart) {

        System.out.println("Установка корпуса");
        this.body = (Body) productPart;

    }

    public Notebook() {
    }
}
