package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_SingleData_Read {
	
	public static void main(String[] args) throws IOException {
		
		// Identifying the File
		FileInputStream excelFile = new FileInputStream("./src/com/ExcelFiles/ExcelOperation.xlsx");
		
		//identify the workbook of the file
		XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
		
		//identify a particular sheet in the workbook
		XSSFSheet testDataSheet = workBook.getSheet("sheet1");
		
		//identify the row in the sheet
		Row row=testDataSheet.getRow(0);
		
		//identify the row of cell in the row
		Cell rowofCell=row.getCell(0);
		
		//read the data in the row of cell
		String testData=rowofCell.getStringCellValue();
		System.out.println(testData);
	}

}
