package com.serenity.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndWrite 
{
	
	public ArrayList<String> ReadExcelAndGiveEAN(int numberOfItemsToSeach){
		ArrayList<String> EAN=null;
	try {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\kailash.sopparapu\\Desktop\\JDMY.xlsx"));
		EAN=new ArrayList<String>();       
        XSSFWorkbook workcopy = new XSSFWorkbook(file);        
        XSSFSheet sheet = workcopy.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("****** "+rowCount);
        Row row;
        String cellValueMaybeNull=null;
        
        for (int rowIndex = 0; rowIndex <= numberOfItemsToSeach; rowIndex++) {
        	  row = sheet.getRow(rowIndex);
        	  if (row != null) {
        	    Cell cell = row.getCell(12);
        	    if (cell != null) {
        	  switch (cell.getCellType()) {
                  case Cell.CELL_TYPE_NUMERIC:
                	  String str = NumberToTextConverter.toText(cell.getNumericCellValue());
                	  EAN.add(str);
                      System.out.println(str);
                      break;
                  case Cell.CELL_TYPE_STRING:
                      System.out.println(cell.getStringCellValue());
                      break;
                  }
        	    }
        	  }
        	}
       
        
       
        file.close();
        
    }
    catch (Exception e) {
        e.printStackTrace();
    }
	return EAN;
	
	
	
}
	public String getDate(){
		Date myDate = new Date();
		
		return new SimpleDateFormat("MM-dd-yyyy").format(myDate);
		
	}
	
	public String getSystemTime(){
		String timeStamp = new SimpleDateFormat("HH:mm:ss a").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	public void WriteExcelFile(ArrayList<String> eanList,ArrayList<String> soH,ArrayList<String> ccATS) throws FileNotFoundException, IOException{
		FileInputStream  file= new FileInputStream(new File("C:\\Users\\kailash.sopparapu\\Desktop\\Stocks.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int i=0;i<eanList.size();i++){
        	
        	Object[][] bookData = {
                    {eanList.get(i), soH.get(i),ccATS.get(i) },
                    
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
        }
        
        
        
         
         
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\kailash.sopparapu\\Desktop\\stocks.xlsx")) {
            workbook.write(outputStream);
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ExcelReadAndWrite dr=new ExcelReadAndWrite();
	
		ArrayList<String> EanList=new ArrayList<String>();
		EanList=dr.ReadExcelAndGiveEAN(100);
	//	dr.WriteExcelFile(EanList, "1", "2");
		
	}
	

}
