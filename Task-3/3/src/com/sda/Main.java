package com.sda;

public class Main {

    public static void main(String[] args) {

        var body = new BodyLineStep();
        var board = new MatherBoardLineStep();
        var display = new DisplayLineStep();

        NotebookAssemblyLine notebookAssemblyLine = new NotebookAssemblyLine(board, display,body);
        Notebook notebook = (Notebook) notebookAssemblyLine.assemblyProduct(new Notebook());


    }
}
