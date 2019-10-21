package com.sda;

public class Main {

    public static void main(String[] args) {

        System.out.println("Изготовление материнской платы");
        MatherBoard matherBoard = new matherBoardLineStep().buildProductPart();
        System.out.println("Изготовление дисплея");
        Display display = new DisplayLineStep().buildProductPart();
        System.out.println("Изготовление корпуса");
        Body body = new BodyLineStep().buildProductPart();
        System.out.println("Начало сборки");
        NotebookAssemblyLine notebookAssemblyLine = new NotebookAssemblyLine();
        Notebook notebook = (Notebook) notebookAssemblyLine.assemblyProduct(body, display, matherBoard);
        System.out.println("Ноутбук собран");

    }
}
