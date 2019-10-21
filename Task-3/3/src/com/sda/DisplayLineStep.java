package com.sda;

public class DisplayLineStep implements ILineStep {

    @Override
    public Display buildProductPart() {
        Display display = new Display("1920x1080");
        return display;
    }
}
