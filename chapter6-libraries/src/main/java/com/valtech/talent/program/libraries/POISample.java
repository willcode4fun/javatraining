package com.valtech.talent.program.libraries;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

@Slf4j
public class POISample {

    private static final String FILE_NAME = "/home/tomchuck/tmp/valtech-talent.xlsx";


    public static void main(String[] args) throws IOException {

        writeExcelFile();

        readExcelFile();

    }

    private static void readExcelFile() throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        log.info("Datasheet name : {}", sheet.getSheetName());

        sheet.iterator().forEachRemaining(row -> {
            row.cellIterator().forEachRemaining(cell -> log.info("CELL {},{} : {}", cell.getRowIndex(), cell.getColumnIndex(), cell.getStringCellValue()));
        });
    }

    private static void writeExcelFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("ValtechTalent");
        IntStream.range(1, 10).forEach(rowNum -> {
            Row row = sheet.createRow(rowNum);
            IntStream.range(1, 10).forEach(colNum -> {
                row.createCell(colNum).setCellValue("TEST");
            });
        });
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
}
