package com.serenity.commonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderAndWriter 
{
	
	public void ReadExcel(){
		
	try {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\kailash.sopparapu\\Desktop\\sample.xlsx"));

        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("****** "+rowCount);
        // Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                // Check the cell type and format accordingly
                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t");
                    break;
                }
            }
            System.out.println("");
        }
        file.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}
	public String getDate(){
		Date myDate = new Date();
		
		return new SimpleDateFormat("MM-dd-yyyy").format(myDate);
		
	}
	
	public String getSystemTime(){
		String timeStamp = new SimpleDateFormat("HH:mm:ss a").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	public void WriteExcelFile(String orderNumber) throws FileNotFoundException, IOException{
		FileInputStream  file= new FileInputStream(new File("C:\\Users\\kailash.sopparapu\\Desktop\\sample.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String date=getDate();
        String time=getSystemTime();
        Object[][] bookData = {
                {orderNumber, date,time },
                
        };
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\kailash.sopparapu\\Desktop\\sample.xlsx")) {
            workbook.write(outputStream);
        }
    }
	

}
