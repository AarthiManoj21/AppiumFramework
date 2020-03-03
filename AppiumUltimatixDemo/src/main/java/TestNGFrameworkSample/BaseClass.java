package TestNGFrameworkSample;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestNGFrameworkSample.ExtentReportsDemo;

public class BaseClass extends ExtentReportsDemo{

	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeTest
	public void setup() throws IOException
	{
		cap.setCapability("deviceName","ZY322HJCVM");
		cap.setCapability("platformName","Android");
		cap.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(CapabilityType.VERSION,"8.1.0");
		cap.setCapability("chromedriverExecutable","C:\\Users\\user\\Desktop\\chromedriver.exe");
	}
	@Test
	public void sampleTest() throws IOException, InterruptedException, Exception
	{  
		ExtentTest test = extent.createTest("TestNG", "Ultimatix Login");
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		System.out.println("Hello Appium");
		driver.get("https://www.ultimatix.net");

		WebElement userName=driver.findElement(By.id("form1"));			
		userName.click();
		userName.sendKeys("Aarthi.R");	
		test.log(Status.PASS, "Added UserName"+test.addScreenCaptureFromPath(captureScreen()));

		WebElement proceedBtn=driver.findElement(By.id("proceed-button"));	 
		proceedBtn.click(); 

		WebElement passwordButton=driver.findElement(By.id("password-btn"));
		passwordButton.click();

		WebElement enterPassWord=driver.findElement(By.id("password-login"));
		enterPassWord.sendKeys("amc@20,FEB");
		test.log(Status.PASS, "Password Entered Successfully"+test.addScreenCaptureFromPath(captureScreen()));

		WebElement loginButton=driver.findElement(By.id("form-submit"));
		loginButton.click();
		Thread.sleep(5000);
		test.log(Status.PASS, "Login Success"+test.addScreenCaptureFromPath(captureScreen()));
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
		System.out.println("Driver Quitted Successfully");				
	}
}



