package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_MultipleData {
	public static void main(String[] args) throws IOException {
		
		FileInputStream testDataFile = new FileInputStream("./src/com/ExcelFiles/MultipleData.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
		
		XSSFSheet testDataSheet = workBook.getSheet("sheet1");
		
		int activeRowCount=testDataSheet.getLastRowNum();
		
		for(int rowindex=0;rowindex<=activeRowCount;rowindex++)
		{
			Row activeRow=testDataSheet.getRow(rowindex);
			
			int activeRowOfCellCount=activeRow.getLastCellNum();
			
			for(int activeRowOfCellindex=0;activeRowOfCellindex<=activeRowOfCellCount;activeRowOfCellindex++)
			{
				Row row=testDataSheet.getRow(rowindex);
				
				Cell rowOfCell=row.getCell(activeRowOfCellindex);
				
				String testData=rowOfCell.getStringCellValue();
				
				System.out.print(testData+" ");
			}
			
			System.out.println();
		}
		
	}

}
