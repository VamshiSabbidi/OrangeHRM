package com.BrowsersTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\selenium\\WebApplicationTesting\\BrowserDriverFiles\\chromedriver.exe");
		ChromeDriver chromebrowser = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", ".\\BrowserDriverFiles\\msedgedriver.exe");
		EdgeDriver edgebrowser = new EdgeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\LENOVO\\Desktop\\selenium\\WebApplicationTesting\\BrowserDriverFiles\\geckodriver.exe");
		//FirefoxDriver firefoxbrowser = new FirefoxDriver();
	}

}
