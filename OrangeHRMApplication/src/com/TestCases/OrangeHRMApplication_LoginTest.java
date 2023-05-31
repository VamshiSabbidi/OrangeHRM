package com.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class OrangeHRMApplication_LoginTest extends BaseTest {
	FileInputStream propertiesFile;
	FileInputStream testDataFile;
	Row testDataRow;
	Cell testRowOfCell;
	
	@Test(priority=1,description="valadating orangeHRMapplication Homepage ")
	public void validatingOrangeHRMApplicationLogInPageTest() throws IOException
	{
		propertiesFile = new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		Properties properties = new Properties();
		properties.load(propertiesFile);
		
		//validating OrangeHRMApplication Login Page Title
		String expected_OrangeHRMApplicationLoginPageTitle="OrangeHRM";
		System.out.println("The Expected OrangeHRM Application Login Page Title is "+expected_OrangeHRMApplicationLoginPageTitle);
		
		String actual_OrangeHRMApplicationLogInPageTitle=driver.getTitle();
		System.out.println(" The Actual title of the OrnageHRM Application LogIn Page is:- "+actual_OrangeHRMApplicationLogInPageTitle);
		
		if(actual_OrangeHRMApplicationLogInPageTitle.equals(expected_OrangeHRMApplicationLoginPageTitle))
		{
			System.out.println("Successfully Navigated to OrangeHrmApplication Login page - PASS");
		}
		else
		{
			System.out.println("Not Navigated to OrangeHRMApplication Login page - FAIL");
		}
		
		//validating OrangeHRMApplication Login Page URl address
		String expected_OrangeHRMApplicationLoginPageUrlAddress="orangehrm-4.2.0.1";
		System.out.println("The Expected OrangeHRM Application Login Page Url Address is "+expected_OrangeHRMApplicationLoginPageUrlAddress);
		
		String actual_OrangeHRMApplicationLoginPageUrlAddress=driver.getCurrentUrl();
		System.out.println("The Actual OrangeHRM Application Login Page Url Address is "+actual_OrangeHRMApplicationLoginPageUrlAddress);
		
		if(actual_OrangeHRMApplicationLoginPageUrlAddress.contains(actual_OrangeHRMApplicationLoginPageUrlAddress))
		{
			System.out.println("Successfully Navigated to OrangeHrmApplication Login page - PASS");
		}
		else
		{
			System.out.println("Not Navigated to OrangeHRMApplication Login page - FAIL");
		}
		
		//validating OrangeHRM Application login page Text
		String expected_OrangeHRMApplicationLoginPageText="LOGIN Panel";
		System.out.println("The Expected OrangeHRM Application Login Page Text is "+expected_OrangeHRMApplicationLoginPageText);
		
		By orangeHRMApplicationLoginPageTextLocator=By.id(properties.getProperty("orangeHRMApplicationLogInPanelLocatorProperty"));
		WebElement orangeHRMApplicationLoginPageText=driver.findElement(orangeHRMApplicationLoginPageTextLocator);
		String actual_OrangeHRMApplicationLoginPageText=orangeHRMApplicationLoginPageText.getText();
		System.out.println("The Actual OrangeHRM Application Login Page Text is "+actual_OrangeHRMApplicationLoginPageText);
		
		if(actual_OrangeHRMApplicationLoginPageText.equals(actual_OrangeHRMApplicationLoginPageText))
		{
			System.out.println("Successfully Navigated to OrangeHrmApplication Login page - PASS");
		}
		else
		{
			System.out.println("Not Navigated to OrangeHRMApplication Login page - FAIL");
		}
	}
	
	@Test(priority=2,description="Validating OrangeHRM Application LogIn Functionality Test")
	public void validatingOrangeHRMApplicationLoginFunctionality() throws IOException
	{
		testDataFile = new FileInputStream("./src/com/ApplicationTestDataFile/ExcelOperation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(testDataFile);
		XSSFSheet testDataSheet = workbook.getSheet("sheet1");
		
		testDataRow = testDataSheet.getRow(1);
		testRowOfCell=testDataRow.getCell(0);
		String userNameTestData=testRowOfCell.getStringCellValue();
		System.out.println("The userName TestData is "+userNameTestData);
		
		//validating username
		propertiesFile = new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		Properties properties = new Properties();
		properties.load(propertiesFile);
		
		By userNameLocator=By.id(properties.getProperty("orangeHRMApplicationUserNameLocatorProperty"));
		WebElement userName=driver.findElement(userNameLocator);
		userName.sendKeys(userNameTestData);
		
		testRowOfCell=testDataRow.getCell(1);
		String passwordTestData=testRowOfCell.getStringCellValue();
		System.out.println("The Password TestData is "+passwordTestData);
		
		//validating password
		By passwordLocator=By.id(properties.getProperty("orangeHRMApplicationPasswordLocatorProperty"));
		WebElement password=driver.findElement(passwordLocator);
		password.sendKeys(passwordTestData);
		
		//validating login button
		By loginButtonLocator=By.id(properties.getProperty("orangeHRMApplicationLoginButtonLocatorProperty"));
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
		
		String expected_OrangeHRMApplicationHomePageText="welcome";
		System.out.println("The Expected OrangeHRM Application HomePage Text is "+expected_OrangeHRMApplicationHomePageText);
		
		By welComeAdminLocator=By.id(properties.getProperty("orangeHRMApplicationWelComeAdminLocatorProperty"));
		WebElement welComeAdmin=driver.findElement(welComeAdminLocator);
		String actual_welComeAdminText=welComeAdmin.getAttribute("id");
		System.out.println("The OrangeHRM Application HomePage text is "+actual_welComeAdminText);
		
		if(actual_welComeAdminText.contains(expected_OrangeHRMApplicationHomePageText))
		{
			System.out.println("Successfully Navigated to OrangeHRM Application HomePage - PASS ");
		}
		else
		{
			System.out.println("Not Navigated to OrangeHRM Applicatio HomePage - FAIL");
		}
	}
	
		@Test(priority=3,description="validating LogOut Functionality")
		public void validatingOrangeHRMApplicationLogoutFunctionality() throws IOException, InterruptedException
		{
		
		propertiesFile = new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		Properties properties = new Properties();
		properties.load(propertiesFile);
		
		By weComeAdminLocator=By.partialLinkText(properties.getProperty("orangeHRMApplicationHomePageWelComeAdminLocatorProperty"));
		WebElement welComeAdmin=driver.findElement(weComeAdminLocator);
		welComeAdmin.click();
		
		Thread.sleep(5000);
		
		By logOutLocator=By.linkText(properties.getProperty("orangeHRMApplicationHomePageLogOutLocatorProperty"));
		WebElement logOut=driver.findElement(logOutLocator);
		logOut.click();
		
	}
}
