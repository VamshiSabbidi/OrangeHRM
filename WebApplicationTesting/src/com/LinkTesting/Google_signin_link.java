package com.LinkTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_signin_link {
	public static void main(String[] args) {
		
		WebDriver driver;
		String GoogleUrlAddress="http://google.com";
		
		 System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.get(GoogleUrlAddress);
		 
		 //<a class="gb_ma gb_Wd gb_Qd gb_id" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top"><span class="gb_Sd">Sign in</span></a>
		 
		 By GoogleSigninLocator=By.linkText("Sign in");
		 WebElement GoogleSignin=driver.findElement(GoogleSigninLocator);
		 GoogleSignin.click();
		 
	}

}
