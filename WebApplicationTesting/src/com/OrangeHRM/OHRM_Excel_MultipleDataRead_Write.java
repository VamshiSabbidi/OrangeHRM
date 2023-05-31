package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_Excel_MultipleDataRead_Write {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(ApplicationUrlAddress);
		
		FileInputStream testDataFile = new FileInputStream("./src/com/ExcelFiles/OHRM_MultipleData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
		XSSFSheet testDataSheet = workBook.getSheet("sheet1");
		
		int rowCount =testDataSheet.getLastRowNum();
		
		for(int rowindex=1; rowindex<=rowCount; rowindex++)
		{
			Row rowtext=testDataSheet.getRow(rowindex);
			
			int rowofcellcount=rowtext.getLastCellNum();
			for(int rowofcellindex=0; rowofcellindex<=rowofcellcount; rowofcellindex++)
			{
				Row row=testDataSheet.getRow(rowindex);
				
				Cell rowofcell=row.getCell(rowofcellindex);
				String rowofcelltext=rowofcell.getStringCellValue();
				
				By userNameLocator=By.id("txtUsername");
				WebElement userName=driver.findElement(userNameLocator);
				userName.sendKeys(rowofcelltext);
				
				
			}
			
		}
	}
	

}
