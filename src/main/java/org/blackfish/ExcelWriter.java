package org.blackfish;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.SortedSet;

public class ExcelWriter {

    public static void printNapiBontas(NapiBontas napiBontas, String kimenoFileNev) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Eredmenyek");
        //Napibontas kiirasa
        int rowNum = 0;
        for (LocalDate nap :
                napiBontas.keySet()) {
            Row headerSor = sheet.createRow(rowNum++);
            Cell napiHeader = headerSor.createCell(rowNum);
            Row uresSor = sheet.createRow(rowNum++);

            for (String ember :
                    napiBontas.get(nap).keySet()) {
                SortedSet<LocalDateTime> meresekSorban = napiBontas.get(nap).get(ember);
                //nev
                Row emberAznapiElsoUtolso = sheet.createRow(rowNum++);
                Cell nevCella = emberAznapiElsoUtolso.createCell(0);
                nevCella.setCellValue(ember);
                //elsomeres
                Cell elsoMeres = emberAznapiElsoUtolso.createCell(1);
                elsoMeres.setCellValue(napiBontas.get(nap).get(ember).first());
                //masodikmeres
                Cell masodikMeres = emberAznapiElsoUtolso.createCell(2);
                masodikMeres.setCellValue(napiBontas.get(nap).get(ember).first());
                Row uresSorPerEmber = sheet.createRow(rowNum++);
            }
        }
        try {
            //Write the workbook in file system
            URL url = ExcelWriter.class.getClassLoader().getResource(
                    kimenoFileNev);
            FileOutputStream out = new FileOutputStream(url.getFile());
            workbook.write(out);
            out.close();

            System.out.println(kimenoFileNev + " written successfully on " +
                    "disk.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

