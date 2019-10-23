package com.sda;

public class NotebookAssemblyLine implements IAssemblyLine {

    private ILineStep firstProductStep;
    private ILineStep secondProductStep;
    private ILineStep thirdProductStep;

    public NotebookAssemblyLine(ILineStep firstProductStep, ILineStep secondProductStep, ILineStep thirdProductStep) {

        this.firstProductStep = firstProductStep;
        this.secondProductStep = secondProductStep;
        this.thirdProductStep = thirdProductStep;

    }

    @Override
    public IProduct assemblyProduct(IProduct notebook) {

        System.out.println("Сборочная линия запущена");
        notebook.installFirstPart(firstProductStep.buildProductPart());
        notebook.installSecondPart(secondProductStep.buildProductPart());
        notebook.installThirdPart(thirdProductStep.buildProductPart());
        System.out.println("Ноутбук собран");
        return notebook;

    }

}