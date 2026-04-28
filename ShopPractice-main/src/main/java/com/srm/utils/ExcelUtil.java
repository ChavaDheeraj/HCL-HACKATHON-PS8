package com.srm.utils;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    static String path = System.getProperty("user.dir") + "/src/testdata/TestData.xlsx";

    public static void writeEmail(String email) {
        try {
            File file = new File(path);
            Workbook wb;
            Sheet sheet;

            if (!file.exists()) {
                wb = new XSSFWorkbook();
                sheet = wb.createSheet("Users");
            } else {
                FileInputStream fis = new FileInputStream(file);
                wb = WorkbookFactory.create(fis);
                sheet = wb.getSheet("Users");
                if (sheet == null) sheet = wb.createSheet("Users");
            }

            int lastRow = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRow + 1);
            row.createCell(0).setCellValue(email);

            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getEmail() {
        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/testdata/TestData.xlsx"
            );

            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);

            return sheet.getRow(1).getCell(0).getStringCellValue();

        } catch (Exception e) {
            throw new RuntimeException("Excel read failed. FIX FILE PATH OR FILE FORMAT", e);
        }
    }
}