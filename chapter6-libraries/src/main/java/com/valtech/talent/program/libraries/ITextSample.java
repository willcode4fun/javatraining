package com.valtech.talent.program.libraries;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class ITextSample {

    private static final String FILE_NAME = "/home/tomchuck/tmp/valtech-talent-program.pdf";

    public static void main(String[] args) throws Exception {

        writePDFFile();

    }

    private static void writePDFFile() throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

        //open
        document.open();

        Paragraph p = new Paragraph();
        p.add("Valtech Talent Program");
        p.setAlignment(Element.ALIGN_CENTER);

        document.add(p);
        document.add( new Paragraph("How to write a PDF file with IText"));

        //close
        document.close();
    }
}
