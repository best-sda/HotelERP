package com.sda;

public class NotebookAssemblyLine implements IAssemblyLine {

    Body body;
    Display display;
    MatherBoard matherBoard;

    @Override
    public IProduct assemblyProduct(IProductPart productPart1, IProductPart productPart2, IProductPart productPart3) {
        Notebook notebook = new Notebook();
        notebook.installFirstPart(body);
        notebook.installSecondPart(matherBoard);
        notebook.installThirdPart(display);
        return notebook;
    }
}