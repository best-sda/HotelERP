package com.sda;

public class matherBoardLineStep implements ILineStep {
    @Override
    public MatherBoard buildProductPart() {
       MatherBoard matherBoard  = new MatherBoard("Asus", "intel slylake");
        return matherBoard;
    }
}