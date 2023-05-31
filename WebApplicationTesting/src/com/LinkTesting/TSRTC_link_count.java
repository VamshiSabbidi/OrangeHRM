package com.LinkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_link_count {
	public static void main(String[] args) {
		
		WebDriver driver;
		String TSRTCUrlAddress="https://www.tsrtconline.in/oprs-web/";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(TSRTCUrlAddress);
		
//<a class="tabcopy" href="/oprs-web/services/cancel.do" target="_top" title="Cancelled Services">Cancelled Services</a>
//<a class="tabcopy" href="/oprs-web/services/driverInfo.do" target="_top" title="Driver Info">Driver Info</a>
		
		By TSRTClinkcLocator=By.tagName("a");
		List<WebElement> TSRTCLink=driver.findElements(TSRTClinkcLocator);
		int TSRTClinkcount = TSRTCLink.size();
		System.out.println("The number of Liks on the TSRTC application Homepage are :- "+TSRTClinkcount);
		System.out.println(TSRTCLink);
		
		for(int index=0; index<TSRTClinkcount; index++)
		{
			String TSRTClinksName=TSRTCLink.get(index).getText();
			System.out.println(index+" - "+TSRTClinksName);
		}
		
		driver.quit();
	}

}
