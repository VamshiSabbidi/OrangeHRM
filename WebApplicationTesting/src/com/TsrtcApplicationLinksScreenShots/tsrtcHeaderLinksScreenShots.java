package com.TsrtcApplicationLinksScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tsrtcHeaderLinksScreenShots {
	
	public static void main(String[]args) throws IOException {

	WebDriver driver;
	String tsrtcHomePageUrlAddress="https://www.tsrtconline.in/oprs-web/";

	System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get(tsrtcHomePageUrlAddress);
	
	//<div class="menu-wrap">
	By tsrtcHeaderBlockLocator=By.className("menu-wrap");
	WebElement tsrtcHeaderBlockLinks=driver.findElement(tsrtcHeaderBlockLocator);
	
	By tsrtcHeaderBlockLocator2=By.tagName("a");
	List<WebElement>tsrtcHeaderBlock=tsrtcHeaderBlockLinks.findElements(tsrtcHeaderBlockLocator2);
	
	int tsrtcHeaderBlockLinkCount=tsrtcHeaderBlock.size();
	System.out.println("The Links on TSRTC Application HeaderBlock are:- "+tsrtcHeaderBlockLinkCount);
	
	for(int index=0;index<tsrtcHeaderBlockLinkCount;index++)
	{
		String tsrtcHeaderBlockLinkNames=tsrtcHeaderBlock.get(index).getText();
		System.out.println(index+" - "+tsrtcHeaderBlockLinkNames);
		
		tsrtcHeaderBlock.get(index).click();
		
		File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,new File("./TsrtcApplicationScreenShots/screenshot.png"));
		
		//FileUtils.copyFile(screenShot,new File("./TsrtcApplicationScreenShots/screenshot.png"));

		String webpagetitle=driver.getTitle();
		System.out.println(webpagetitle);
		
		String webpageurl=driver.getCurrentUrl();
		System.out.println(webpageurl);
		
		
		driver.navigate().back();
		
		System.out.println();
		
		tsrtcHeaderBlockLinks=driver.findElement(tsrtcHeaderBlockLocator);
		tsrtcHeaderBlock=tsrtcHeaderBlockLinks.findElements(tsrtcHeaderBlockLocator2);
	}
	driver.quit();
}
	
}
