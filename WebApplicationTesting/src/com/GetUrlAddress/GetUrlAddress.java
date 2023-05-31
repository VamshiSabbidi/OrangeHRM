package com.GetUrlAddress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetUrlAddress {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://facebook.com");
		
		String facebookloginpageurladdress=driver.getCurrentUrl();
		System.out.println(facebookloginpageurladdress);
		
		//<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email" placeholder="Email address or phone number" autofocus="1" aria-label="Email address or phone number">		
		driver.findElement(By.id("email")).sendKeys("vamshi");
		
		//<input type="password" class="inputtext _55r1 _6luy _9npi" name="pass" id="pass" data-testid="royal_pass" placeholder="Password" aria-label="Password">
		driver.findElement(By.id("pass")).sendKeys("hello");
		
		//<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_5_JO">Log in</button>
		driver.findElement(By.name("login")).click();
		
	}
	
	
	
	

}
