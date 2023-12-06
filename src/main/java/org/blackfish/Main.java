package org.blackfish;


import javax.swing.*;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
//        String filename = readFilenameFromConsole();
//        int datumOszlopSorszama = readDatumSorszamFromConsole();
//        int nevSorszama = readNevSorszamaFromConsole();
//
//        ExcelReader excelReader = new ExcelReader();
//        NapiBontas napiBontas = excelReader.readExcel(filename, datumOszlopSorszama, nevSorszama);
//        ExcelWriter.printNapiBontas(napiBontas,"eredmeny.xlsx");
//
        new PickFileToRead();
    }

    private static int readNevSorszamaFromConsole() {
        Console console = System.console();
        String nevOszlop = console.readLine("Leci add meg a nev hanyadik oszlopban van: ");
        int nevOszlopInt = Integer.parseInt(nevOszlop);
        return nevOszlopInt;


    }

    private static int readDatumSorszamFromConsole() {
        Console console = System.console();
        String datumOszlop = console.readLine("Leci add meg a meres datum/idopontja hanyadik oszlopban van: ");
        int nevOszlopInt = Integer.parseInt(datumOszlop);
        return nevOszlopInt;
    }

    private static String readFilenameFromConsole() {
        Console console = System.console();
        String filenev = console.readLine("Leci add meg a file eleresi utvonalat, pl.: \"c:/temp/peldafile.xlsx\" ");


        return filenev;
    }
    private void createGui() {
        JFrame jframe = new JFrame("Elso utolso meres");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 400);
        JButton goButton = new JButton("Go");  //create firstButton object
        jframe.getContentPane().add(goButton);
        jframe.setVisible(true);

    }
}