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
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployee {

	public static void main(String[] args) throws InterruptedException, IOException {

	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard"; // variable saved with url Address

	System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
	driver = new ChromeDriver();

	// Maximizing the Browser
	driver.manage().window().maximize();

	driver.get(applicationUrlAddress); // passing the variableName - instead of urlAddress

	// validating title of OrnageHRM Application LogIn Page

	String expected_OrangeHRMApplicationLogInPageTitle="OrangeHRM";
	System.out.println(" The Expected title of the OrnageHRM Application LogIn Page is:- "+expected_OrangeHRMApplicationLogInPageTitle);

	String actual_OrangeHRMApplicationLogInPageTitle=driver.getTitle();
	System.out.println(" The Actual title of the OrnageHRM Application LogIn Page is:- "+actual_OrangeHRMApplicationLogInPageTitle);

	if(actual_OrangeHRMApplicationLogInPageTitle.equals(expected_OrangeHRMApplicationLogInPageTitle))
	{
	System.out.println(" Title of OrangeHRM Application LogIn Page Matched - PASS");
	}
	else
	{
	System.out.println(" Title of OrangeHRM Application LogIn Page NOT Matched - FAIL");
	}


	// validating URL of OrnageHRM Application LogIn Page
	String expected_OrangeHRMApplicationLogInPageUrlAddress="orangehrm-4.2.0.1";
	System.out.println(" The Expected Url address of the OrnageHRM Application LogIn Page is:- "+expected_OrangeHRMApplicationLogInPageUrlAddress);

	String actual_OrangeHRMApplicationLogInPageUrlAddress=driver.getCurrentUrl();
	System.out.println(" The actual Url address of the OrnageHRM Application LogIn Page is:- "+actual_OrangeHRMApplicationLogInPageUrlAddress);

	if(actual_OrangeHRMApplicationLogInPageUrlAddress.contains(expected_OrangeHRMApplicationLogInPageUrlAddress))
	{
	System.out.println(" URL Address of OrangeHRM Application found with the expected text - PASS");
	}
	else
	{
	System.out.println("URL Address of OrangeHRM Application NOT found with the expected text - FAIL");
	}

	String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	System.out.println(" Thed expected text of OrangeHRM Application LogIn Page is :- "+expected_OrangeHRMApplicationLogInPageText);

	// <div id="logInPanelHeading">LOGIN Panel</div>
	By logInPanelLocator=By.id("logInPanelHeading");
	WebElement logInPanel=driver.findElement(logInPanelLocator);
	String actual_OrangeHRMApplicationLogInPanelText=logInPanel.getText();

	System.out.println(" THe actual text of OrangeHRM Application LogIn Page is :- "+actual_OrangeHRMApplicationLogInPanelText);

	if(actual_OrangeHRMApplicationLogInPanelText.equals(expected_OrangeHRMApplicationLogInPageText))
	{
	System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
	}
	else
	{
	System.out.println("Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
	}

	// validating LogIn Functionality - test data from External file Excel
	// Identifying the external file Excel

	FileInputStream testDataFile = new FileInputStream("./src/com/ExcelFiles/OHRMLogIn.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
	XSSFSheet testDataSheet = workBook.getSheet("Sheet1");

	// Reading the data from the Row of a Cell
	Row testDataRow=testDataSheet.getRow(1);
	Cell userNameTestDataRowOfCell=testDataRow.getCell(0);
	String userNameTestData=userNameTestDataRowOfCell.getStringCellValue();

	System.out.println(" The UserName is :- "+userNameTestData);
	//id="txtUsername"
	By userNameLocator=By.id("txtUsername");
	WebElement userName=driver.findElement(userNameLocator);
	userName.sendKeys(userNameTestData); // sending the test data of an Excel file

	Cell passwordTestDataRowOfCell=testDataRow.getCell(1);
	String passwordTestData=passwordTestDataRowOfCell.getStringCellValue();
	System.out.println(" The Password is:- "+passwordTestData);

	//name="txtPassword"
	By passwordLocator=By.name("txtPassword");
	WebElement password=driver.findElement(passwordLocator);
	password.sendKeys(passwordTestData); // sending the test data of an Excel file

	// class="button"
	By logInPageLogInButtonLocator=By.className("button");
	WebElement logInPageLogInButton=driver.findElement(logInPageLogInButtonLocator);
	logInPageLogInButton.click();

	String expected_OrangeHRMApplicationHomePageText="Admin";
	System.out.println(" The Expected OrnageHRM Application HomePage Text is:- "+expected_OrangeHRMApplicationHomePageText);

	// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	By welcomeAdminLocator=By.partialLinkText("Welcome");
	WebElement welComeAdmin=driver.findElement(welcomeAdminLocator);
	String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();

	System.out.println(" The Actual OrnageHRM Application HomePage Text is:- "+actual_OrangeHRMApplicationHomePageText);

	if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
	{
	System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS");

	Cell newCell=testDataRow.createCell(2);
	newCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");

	}
	else
	{
	System.out.println(" Failed to navigate to OrangeHRM Application HomePage - FAIL");
	Cell newCell=testDataRow.createCell(2);
	newCell.setCellValue("Failed to navigate to OrangeHRM Application HomePage - FAIL");
	}

	FileOutputStream fileOutPut = new FileOutputStream("./src/com/ExcelFiles/OHRMLogIn.xlsx");
	workBook.write(fileOutPut);
	
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
	By pimLocator=By.linkText("PIM");
	WebElement pimLink=driver.findElement(pimLocator);
	Actions pim=new Actions(driver);
	pim.moveToElement(pimLink).build().perform();
	
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
	By addEmployeeLocator=By.linkText("Add Employee");
	WebElement addEmployeeLink=driver.findElement(addEmployeeLocator);
	addEmployeeLink.click();
	
	String expected_FullNameText="Full Name";
	System.out.println("The Expected Text on Add Employee Page is:- "+expected_FullNameText);
	
	//<label class="hasTopFieldHelp">Full Name</label>
	By fullNameLocator=By.className("hasTopFieldHelp");
	WebElement fullName=driver.findElement(fullNameLocator);
	String actual_FullNameText=fullName.getText();
	System.out.println("The Actual Text on Add Employee Page is:- "+actual_FullNameText);
	
	if(actual_FullNameText.equals(actual_FullNameText))
	{
		System.out.println("Successfully Navigated To Add Employee Page - PASS");
	}
	else
	{
		System.out.println("Not Navigated To Add Employee Page - FAIL");
	}
	
	//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
	String expected_FirstName="Sabbidi";
	By firstNameTextBoxLocator=By.name("firstName");
	WebElement firstNameTextBox=driver.findElement(firstNameTextBoxLocator);
	firstNameTextBox.sendKeys(expected_FirstName);
	
	//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
	String expected_MiddleName=" ";
	By middleNameTextBoxLocator=By.id("middleName");
	WebElement middleNameTextBox=driver.findElement(middleNameTextBoxLocator);
	middleNameTextBox.sendKeys(expected_MiddleName);
	
	//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
	String expected_LastName="Vamshi";
	By lastNameTextBoxLocator=By.id("lastName");
	WebElement lastNameTextBox=driver.findElement(lastNameTextBoxLocator);
	lastNameTextBox.sendKeys(expected_LastName);
	
	//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
	By employeeIDLocator=By.id("employeeId");
	WebElement employeeID=driver.findElement(employeeIDLocator);
	String expected_EmployeeID=employeeID.getAttribute("value");
	System.out.println("The Employee ID is:- "+expected_EmployeeID);
	
	//<input type="button" class="" id="btnSave" value="Save">
	By saveButtonLocator=By.id("btnSave");
	WebElement saveButton=driver.findElement(saveButtonLocator);
	saveButton.click();
	
	//<input value="Sabbidi" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
	By firstnameLocator=By.id("personal_txtEmpFirstName");
	WebElement firstname=driver.findElement(firstnameLocator);
	String actual_FirstName=firstname.getAttribute("value");
	System.out.println("The Actual First Name is:- "+actual_FirstName);
	
	if(actual_FirstName.equals(expected_FirstName))
	{
		System.out.println("The Actual and Expected First Name is Matched - PASS");
	}
	else
	{
		System.out.println("The Actual and Expected First Name is Not Matched - FAIL");
	}
	
	//<input value="" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
	By middlenameLocator=By.id("personal_txtEmpMiddleName");
	WebElement middlename=driver.findElement(middlenameLocator);
	String actual_MiddleName=middlename.getAttribute("value");
	System.out.println("The Actual Middle Name is:- "+actual_MiddleName);
	if(actual_MiddleName.equals(expected_MiddleName))
	{
		System.out.println("The Actual and Expected Middle Name is Matched - PASS");
	}
	else
	{
		System.out.println("The Actual and Expected Middle Name is Not Matched - FAIL");
	}
	
	//<input value="Vamshi" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
	By lastnameLocator=By.id("personal_txtEmpLastName");
	WebElement lastname=driver.findElement(lastnameLocator);
	String actual_LastName=lastname.getAttribute("value");
	System.out.println("The Actual Last Name is:- "+actual_LastName);
	if(actual_LastName.equals(expected_LastName))
	{
		System.out.println("The Actual and Expected Last Name is Matched - PASS");
	}
	else
	{
		System.out.println("The Actual and Expected Last Name is Not Matched - FAIL");
	}
	
	//<input value="0002" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">
	By employeeidLocator=By.id("personal_txtEmployeeId");
	WebElement employeeid=driver.findElement(employeeidLocator);
	String actual_EmployeeId=employeeid.getAttribute("value");
	System.out.println("The Actual Employee ID is:- "+actual_EmployeeId);
	if(actual_EmployeeId.equals(expected_EmployeeID))
	{
		System.out.println("The Actual and Expected Employee ID is Matched - PASS");
	}
	else
	{
		System.out.println("The Actual and Expected Employee ID is Not Matched - FAIL");
	}
	
	//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	By welcomeadminLocator=By.linkText("Welcome Admin");
	WebElement welcomeadminLink=driver.findElement(welcomeadminLocator);
	welcomeadminLink.click();
	
	// wait - java
	Thread.sleep(5000);

	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	By logOutLocator=By.linkText("Logout");
	WebElement logOut=driver.findElement(logOutLocator);
	logOut.click();

	expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	System.out.println(" Thed expected text of OrangeHRM Application LogIn Page is :- "+expected_OrangeHRMApplicationLogInPageText);

	// <div id="logInPanelHeading">LOGIN Panel</div>
	logInPanelLocator=By.id("logInPanelHeading");
	logInPanel=driver.findElement(logInPanelLocator);
	actual_OrangeHRMApplicationLogInPanelText=logInPanel.getText();

	System.out.println(" THe actual text of OrangeHRM Application LogIn Page is :- "+actual_OrangeHRMApplicationLogInPanelText);

	if(actual_OrangeHRMApplicationLogInPanelText.equals(expected_OrangeHRMApplicationLogInPageText))
	{
	System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page - PASS");
	}
	else
	{
	System.out.println("Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
	}

	driver.quit();
	
	}

	}

