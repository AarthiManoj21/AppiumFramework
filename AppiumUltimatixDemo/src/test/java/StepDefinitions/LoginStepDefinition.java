package StepDefinitions;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;

import Pages.BasePage;
import Pages.LoginPage;
import TestNGFrameworkSample.ExtentReportsDemo;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition extends BasePage{

	@Given("^User launches the Browser with Ultimatix URL$")	
	public void user_launches_the_Browser_with_Ultimatix_URL() throws Throwable{
		try
		{
			driver=LaunchBrowser();
			takeScreenShot();
			Reporter.addStepLog("Browser Launched");
				}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@When("^User enters the User Credentials$")
	public void user_enters_the_User_Credentials() throws Throwable {		

		try
		{
			LoginPage login=new LoginPage(driver);		
			login.enterUserName();
			takeScreenShot();
			login.enterPassword();
			takeScreenShot();
			login.clickEnter();
			Thread.sleep(4000);
			takeScreenShot();
			Reporter.addStepLog("Entered Credentials");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Then("^User validates the launch of Home Page with correct User$")
	public void user_Validates_the_presence_of_Home_Page() throws Throwable {
		try {
			LoginPage login=new LoginPage(driver);
			login.homePagePresence();
			takeScreenShot();
			Reporter.addStepLog("Home Page Validation success");
			
		}

		catch (Exception e)
		{
		e.printStackTrace();
		
		}
	}

	@When("^User logout the Application$")
	public void user_logout_the_Application() throws Throwable {	
		try {
			LoginPage login=new LoginPage(driver);
			login.signOut();	
			takeScreenShot();
			Reporter.addStepLog("Logged Out Successfully");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
