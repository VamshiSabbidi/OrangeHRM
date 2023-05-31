package com.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public WebDriver driver;
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@BeforeTest
	public void setUp() {
		
		
	}

}
