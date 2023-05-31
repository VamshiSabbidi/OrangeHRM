package com.NaviagationtoURL;

import org.openqa.selenium.edge.EdgeDriver;

public class GetURL {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "./BrowserDriverFiles/msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		
		driver.navigate().to("http://flipkart.com");
		
		String expected_flipkarthomepagetitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		System.out.println("the expexted flipkart homepage title is-"+expected_flipkarthomepagetitle);
		
		String actual_flipkarthomepagetitle=driver.getTitle();
		System.out.println("the Title of flipkart homepage is-"+actual_flipkarthomepagetitle);
		
		if(actual_flipkarthomepagetitle.equals(expected_flipkarthomepagetitle))
		{
			System.out.println("The Actual and Expected results are matched - PASS");
		}
		else
		{
			System.out.println("The Actual and Expected results are Not matched - FAIL");
		}
		driver.quit();
	}

}
