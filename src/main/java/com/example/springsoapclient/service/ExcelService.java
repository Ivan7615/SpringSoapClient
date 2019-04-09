package com.example.springsoapclient.service;

import com.example.springsoapclient.model.Country;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelService {

    public static void writeResultInExcelFile(List<Country> countryList){
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("new sheet");

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Continent code");
        row.createCell(1).setCellValue("Country code");
        row.createCell(2).setCellValue("Country name");
        row.createCell(3).setCellValue("Capital");
        row.createCell(4).setCellValue("Phone code");
        row.createCell(5).setCellValue("Currency code");

        int rowIter = 2;

        for (Country country : countryList) {
            row = sheet.createRow(rowIter);
            row.createCell(0).setCellValue(country.getContinentalCode());
            row.createCell(1).setCellValue(country.getCountryCode());
            row.createCell(2).setCellValue(country.getCountryName());
            row.createCell(3).setCellValue(country.getCapitalCity());
            row.createCell(4).setCellValue(country.getPhoneCode());
            row.createCell(5).setCellValue(country.getCurrencyCode());
            rowIter++;
        }

        try {
            FileOutputStream fos = new FileOutputStream("src\\main\\resources\\Countries.xlsx");
            workbook.write(fos);
            fos.close();
            System.out.println("\n" + "excel file recorded successfully");
        }
        catch (Exception e){
            System.out.println("\n" + "excel file not recorded!");
        }
    }
}
