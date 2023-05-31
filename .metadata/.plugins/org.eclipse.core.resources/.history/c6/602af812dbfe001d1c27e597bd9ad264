package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods {
	
	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@Given("^User should launch chrome Browser$")
	public void user_should_launch_chrome_Browser()  
	{
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		System.out.println("****** chrome Browser strted successfully **********");
		
	}

	@When("^User should enter valid OrangeHRM Application Url Address$")
	public void user_should_enter_valid_OrangeHRM_Application_Url_Address() 
	{
	   driver.get(applicationUrlAddress);
	}

	@Then("^User should be navigated to OrangeHRM Application LogIn Page$")
	public void user_should_be_navigated_to_OrangeHRM_Application_LogIn_Page()
	{
		  String expected_LogInPanelText="LOGIN Panel";
		   System.out.println("The Expected Text of LogIn Page is:- "+expected_LogInPanelText);
		   
		   //id="logInPanelHeading"
		   By logInPanelLocator=By.id("logInPanelHeading");
		   WebElement logInPanel=driver.findElement(logInPanelLocator);
		   String actual_LogInPanelText=logInPanel.getText();
		   
		   System.out.println("The Actual Text of LogIn Page is:-"+actual_LogInPanelText);
		   
		   if(actual_LogInPanelText.equals(expected_LogInPanelText))
		   {
			   System.out.println("Successfully Navigated to OrangeHRM Application - PASS");
		   }
		   else
		   {
			   System.out.println("Not Navigated to OrangeHRM Application - FAIL");
		   }
		   
	}

	@Then("^User should close the Application along with Browser$")
	public void user_should_close_the_Application_along_with_Browser()
	{
	   driver.quit();
	}


}
