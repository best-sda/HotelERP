package com.sda;

public class MatherBoardLineStep implements ILineStep {
    @Override


    public MatherBoard buildProductPart() {
        System.out.println("Изготовление материнской платы");
        MatherBoard matherBoard  = new MatherBoard("Asus", "intel slylake");
        return matherBoard;
    }
}