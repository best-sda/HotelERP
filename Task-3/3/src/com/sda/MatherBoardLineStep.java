package com.sda;

public class MatherBoardLineStep implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Изготовление материнской платы");
        IProductPart matherBoard = new ProductPart("Matherboard");
        return matherBoard;
    }

}