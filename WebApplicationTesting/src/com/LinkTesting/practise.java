package com.LinkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practise {
	public static void main(String[] args) {
		
		WebDriver driver;
		String tsrtcHomePageUrlAddress="https://www.tsrtconline.in/oprs-web/";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(tsrtcHomePageUrlAddress);
		//<div id="booking">
		//<div class="home-bot-wrap">
		
		By tsrtcFooterLocator=By.id("booking");
		WebElement tsrtcFooter=driver.findElement(tsrtcFooterLocator);
		
		//<a href="#" onclick="populateSearch('5231', 'Hyderabad', '1386430615487', 'Bangalore');">	
		//<a href="#" onclick="populateSearch('1386430615487', 'Bangalore', '5231', 'Hyderabad');">	
		
		By tsrtcFooterLinksLocator=By.tagName("img");
		List<WebElement>tsrtcFooterLinks=tsrtcFooter.findElements(tsrtcFooterLinksLocator);
		
		int tsrtcFooterLinksCount=tsrtcFooterLinks.size();
		System.out.println("The TSRTC Application has Links in Footer are:- "+tsrtcFooterLinksCount);
		
		
		for(int index=0;index<tsrtcFooterLinksCount;index++)
		{
			String tsrtcFooterLinkNames=tsrtcFooterLinks.get(index).getText();
			System.out.println(index+" - "+tsrtcFooterLinkNames);
			
			tsrtcFooterLinks.get(index).click();
			
			String webpagetitle=driver.getTitle();
			System.out.println(webpagetitle);
			
			String webpageUrl=driver.getCurrentUrl();
			System.out.println(webpageUrl);
			
			driver.navigate().back();
			
			System.out.println();
			
			tsrtcFooter=driver.findElement(tsrtcFooterLocator);
			tsrtcFooterLinks=tsrtcFooter.findElements(tsrtcFooterLinksLocator);
		}
		
		driver.quit();
	}

}
