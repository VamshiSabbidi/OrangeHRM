package com.LinkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HeaderBlock_LinkCount {
	public static void main(String[] args) {
		
		WebDriver driver;
		String tsrtcHomePageUrlAddress="https://www.tsrtconline.in/oprs-web/";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(tsrtcHomePageUrlAddress);
		
		//<div class="menu"><div class="menu"><div class="menu-wrap">
		//<div class="menu-wrap">
		
		By tsrtcHeaderBlockLocator=By.className("menu-wrap");
		WebElement tsrtcHeaderBlock=driver.findElement(tsrtcHeaderBlockLocator);
		
		//<a class="tabcopy" href="/oprs-web/services/cancel.do" target="_top" title="Cancelled Services">Cancelled Services</a>
		//<a class="tabcopy" href="/oprs-web/home/aboutus.do" target="_top" title="About Us">About Us</a>
		
		By tsrtcHeaderBlockLocator1=By.tagName("a");
		List<WebElement>tsrtcHeaderBlocklinks=tsrtcHeaderBlock.findElements(tsrtcHeaderBlockLocator1);
		
		int tsrtcHeaderBlockLinksCount=tsrtcHeaderBlocklinks.size();
		System.out.println("The Number of Links in TSRTC HomePage HeaderBlock is:- "+tsrtcHeaderBlockLinksCount);
		
		for(int index=0; index<tsrtcHeaderBlockLinksCount;index++)
		{
			String tsrtcHeaderBlockLinksNames=tsrtcHeaderBlocklinks.get(index).getText();
			System.out.println(index+" - "+tsrtcHeaderBlockLinksNames);
		}
		
		driver.quit();
	}
}
