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

public class OHRM_LogIn {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		String ApplicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(ApplicationUrlAddress);
		
		FileInputStream testDataFile = new FileInputStream("./src/com/ExcelFiles/OHRMLogIn.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
		XSSFSheet testDataSheet = workBook.getSheet("sheet1");
		
		Row row=testDataSheet.getRow(1);
		Cell userNameCell=row.getCell(0);
		String userNameText=userNameCell.getStringCellValue();
		
		By userNameLocator=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameLocator);
		userName.sendKeys(userNameText);
		
		Cell passwordCell=row.getCell(1);
		String passwordText=passwordCell.getStringCellValue();
		
		By passwordLocator=By.id("txtPassword");
		WebElement password=driver.findElement(passwordLocator);
		password.sendKeys(passwordText);
		
		By loginLocator=By.id("btnLogin");
		WebElement loginButton=driver.findElement(loginLocator);
		loginButton.click();
		
		String expected_Text = "Admin";
		
		By OrangeHRMWelcomeAdmin=By.linkText("Welcome Admin");
		WebElement OrangeHRMWelcome=driver.findElement(OrangeHRMWelcomeAdmin);
		String actual_Text=OrangeHRMWelcome.getText();
		System.out.println(actual_Text);
		
		if(actual_Text.contains(expected_Text))
		{
			System.out.println("Sucessfully Navigated to  OHRM Application - PASS ");
			Cell resultCell=row.createCell(2);
			resultCell.setCellValue("Sucessfully Navigated to  OHRM Application - PASS");
		}
		else
		{
			System.out.println("The OHRM Application is not Navigated - FAIL ");
			Cell resultcell=row.createCell(2);
			resultcell.setCellValue("The OHRM Application is not Navigated - FAIL ");
		}
		
		FileOutputStream fileoutput = new FileOutputStream("./src/com/ExcelFiles/OHRMLogIn.xlsx");
		workBook.write(fileoutput);
		
		driver.quit();
	}

}
