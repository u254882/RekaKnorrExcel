package org.blackfish;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class ExcelReader {


    public NapiBontas readExcel(String filenev, int datumOszlopSorszama, int nevSorszama) {
        try {
            System.out.println("filenev" + filenev);
//            filenev = "/Users/peterszilagyi/Downloads/RekaKnorrExcel/peldadatum.xlsx";
            //"c:/temp/fastexcel-demo.xlsx" filenevepelda
            FileInputStream file = new FileInputStream(filenev);


            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            NapiBontas napiBontas = csinaljNapiBontast(rowIterator, nevSorszama, datumOszlopSorszama);


            file.close();
            return napiBontas;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private NapiBontas csinaljNapiBontast(Iterator<Row> rowIterator, int nevSorszama, int datumOszlopSorszama) {
        NapiBontas napiBontas = new NapiBontas();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell nevCella = row.getCell(nevSorszama);
            Cell meresDatumIdoCella = row.getCell(datumOszlopSorszama);
            String nev = getNameFromCell(nevCella);
            LocalDateTime meresDatumido = getDateTimeFromCell(meresDatumIdoCella);
            if (napiBontas.containsKey(meresDatumido.toLocalDate())) {
                TreeMap<String, SortedSet<LocalDateTime>> aznapiNevMeresek = napiBontas.get(meresDatumido.toLocalDate());
                if (aznapiNevMeresek.containsKey(nev)) {
                    aznapiNevMeresek.get(nev).add(meresDatumido);
                } else {
                    SortedSet<LocalDateTime> emberMeresei = new TreeSet<>();
                    emberMeresei.add(meresDatumido);
                    aznapiNevMeresek.put(nev, emberMeresei);
                }

            } else {
                SortedSet<LocalDateTime> emberMeresei = new TreeSet<>();
                emberMeresei.add(meresDatumido);
                TreeMap<String, SortedSet<LocalDateTime>> aznapiNevMeresek = new TreeMap<>();
                aznapiNevMeresek.put(nev, emberMeresei);
                napiBontas.put(meresDatumido.toLocalDate(), aznapiNevMeresek);
            }
        }
        return napiBontas;
    }

    private LocalDateTime getDateTimeFromCell(Cell meresDatumIdoCella) {
        try {
            LocalDateTime meresDatumIdo = meresDatumIdoCella.getLocalDateTimeCellValue();
            return meresDatumIdo;
        } catch (Exception e) {
            System.out.println("Nev cella nem string, sor index:" + meresDatumIdoCella.getRowIndex() + " oszlop index: " + meresDatumIdoCella.getColumnIndex()
                    + "cella tartalom: " + meresDatumIdoCella.getStringCellValue());
            throw new RuntimeException();

        }
    }

    private String getNameFromCell(Cell nevCella) {
        if (nevCella.getCellType() != CellType.STRING) {
            System.out.println("Nev cella nem string, sor index:" + nevCella.getRowIndex() + " oszlop index: " + nevCella.getColumnIndex());
        }
        return nevCella.getStringCellValue();
    }
}

