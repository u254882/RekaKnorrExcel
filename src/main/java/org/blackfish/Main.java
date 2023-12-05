package org.blackfish;


import java.io.Console;

public class Main {
    public static void main(String[] args) {
        String filename = readFilenameFromConsole();
        int datumOszlopSorszama = readDatumSorszamFromConsole();
        int nevSorszama = readNevSorszamaFromConsole();

        ExcelReader excelReader = new ExcelReader();
        excelReader.readExcel(filename, datumOszlopSorszama, nevSorszama);

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
}