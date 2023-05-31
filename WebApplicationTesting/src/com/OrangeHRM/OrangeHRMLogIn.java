package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogIn {
	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		
		String OrangeHRMUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(OrangeHRMUrlAddress);
		
		String Expected_OrangeHRMPageTitle="OrangeHRM";
		String actual_OrangeHRMPageTitle=driver.getTitle();
		
		if(actual_OrangeHRMPageTitle.equals(Expected_OrangeHRMPageTitle))
		{
		System.out.println("The Title of OrangeHRM HomePage is matched - PASS");
		}
		else
		{
			System.out.println("The Title of OrangeHRM HomePage is not matched - FAIL");
		}
		
		String Expected_OrangeHRMWebPageUrlAddress="orangehrm-4.2.0.1";
		String actual_OrangeHRMWebPageUrlAddress=driver.getCurrentUrl();
		if(actual_OrangeHRMWebPageUrlAddress.contains(Expected_OrangeHRMWebPageUrlAddress))
		{
			System.out.println("The UrlAddress of OrangeHRM Homepage is matched - PASS");
		}
		else
		{
			System.out.println("The UrlAddress of OrangeHRM Homepage is not matched - FAIL");
		}
				
		//<input name="txtUsername" id="txtUsername" type="text">
		String UsernameTestData="SabbidiVamshi";
		By OrangeHRMusernamelocator=By.name("txtUsername");
		WebElement OrangeHRMUsername=driver.findElement(OrangeHRMusernamelocator);
		OrangeHRMUsername.sendKeys(UsernameTestData);
		
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		String PasswordTestData="Vamshi@0786";
		By OrangeHRMpasswordlocator=By.id("txtPassword");
		WebElement OrangeHRMpassword=driver.findElement(OrangeHRMpasswordlocator);
		OrangeHRMpassword.sendKeys(PasswordTestData);
		
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		By OrangeHRMLoginPageLogin=By.className("button");
		WebElement OrangeHRMLogin=driver.findElement(OrangeHRMLoginPageLogin);
		OrangeHRMLogin.click();
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		By OrangeHRMWelcomeAdmin=By.linkText("Welcome Admin");
		WebElement OrangeHRMWelcome=driver.findElement(OrangeHRMWelcomeAdmin);
		OrangeHRMWelcome.click();
		
		Thread.sleep(5000);
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		By OrangeHRMLogOutLink=By.linkText("Logout");
		WebElement OrangeHRMLogOut=driver.findElement(OrangeHRMLogOutLink);
		OrangeHRMLogOut.click();
		
		driver.quit();
	}

}
