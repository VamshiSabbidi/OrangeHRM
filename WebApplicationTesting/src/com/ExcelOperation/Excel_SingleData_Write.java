package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_SingleData_Write {
	public static void main(String[] args) throws IOException {
		
		//identifying the file in the system
		FileInputStream testDataFile = new FileInputStream("./src/com/ExcelFiles/ExcelOperation.xlsx");
		
		//identifying the workbook in the file
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
		
		//identify a particular sheet in the workbook
		XSSFSheet testDataSheet = workBook.getSheet("sheet1");
		
		//create a row in the sheet
		Row newRow=testDataSheet.createRow(4);
		
		//create a roe of cell in the row
		Cell newCell=newRow.createCell(1);
		
		newCell.setCellValue("vamshi");
		
		FileOutputStream fileoutput=new FileOutputStream("./src/com/ExcelFiles/ExcelOperation.xlsx");
		workBook.write(fileoutput);
		
	}

}
