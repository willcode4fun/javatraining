package com.valtech.talent.program.mariokart;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.valtech.talent.program.mariokart.com.valtech.talent.program.mariokart.model.Performance;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.IntStream;

public class ChampionshipExportService {

    public static void exportAsExcel(Collection<Performance> raceResults, File targetFile) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Race Results");


            Row headers = sheet.createRow(0);
            headers.createCell(0).setCellValue("Driver");
            headers.createCell(1).setCellValue("Time");

            int driverNum = 1;

            for(Performance perf : raceResults){
                Row driverRow = sheet.createRow(driverNum);
                driverRow.createCell(0).setCellValue(perf.getDriver().getName());
                driverRow.createCell(1).setCellValue(perf.getTimeInSeconds());
                driverNum++;
            }

            FileOutputStream outputStream = new FileOutputStream(targetFile);

            workbook.write(outputStream);
            workbook.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportAsPdf(Collection<Performance> raceResults, File targetFile) {
        try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(targetFile));
            //open
            document.open();

            Paragraph p = new Paragraph();
            p.add("Race Results");
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);
            raceResults.stream().forEach(perf -> {
                try {
                    document.add( new Paragraph(perf.getDriver().getName()+" : "+perf.getTimeInSeconds()));
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                }
            });


            //close
            document.close();
        } catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
