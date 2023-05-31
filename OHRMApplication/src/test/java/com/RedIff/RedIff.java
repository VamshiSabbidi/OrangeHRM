package com.RedIff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedIff {
	
	WebDriver driver;
	String applicationUrlAddress="https://www.rediff.com/";
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(applicationUrlAddress);
		
	}
	
	@Test
	public void validatingFullName() throws InterruptedException {
		
		//<a href="http://register.rediff.com/register/register.php?FormName=user_details" title="Create Rediffmail Account">Create Account</a>
		By createAccountLocator=By.linkText("Create Account");
		WebElement createAccount=driver.findElement(createAccountLocator);
		createAccount.click();
		
		//<input type="text" onblur="fieldTrack(this);" name="name90e4ad1f" value="" style="width:185px;" maxlength="61">
		//<input type="text" onblur="fieldTrack(this);" name="name90e4ad1f" value="" style="width:185px;" maxlength="61">
		////*[@id="tblcrtac"]/tbody/tr[3]/td[3]/input
		
		By fullNameLocator=By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input");
		WebElement fullName=driver.findElement(fullNameLocator);
		fullName.sendKeys("vamshi");
		}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
