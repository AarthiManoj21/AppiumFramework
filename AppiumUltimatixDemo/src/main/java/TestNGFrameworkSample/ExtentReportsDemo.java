package TestNGFrameworkSample;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;

	@BeforeSuite
	//Creates html file for Reporting
	public void reportSetup()
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");	
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		 
	}
	@AfterSuite
	public void reportTeardown()
	{
		extent.flush();
	}

	//To capture Screenshot and Attach in Report File
	public String captureScreen() throws IOException 
	{
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest ="C://Users//user//Appium//AppiumUltimatixDemo//Screenshots//"+getcurrentdateandtime()+".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	//Gets the Current date and time to name the pics saved under Screenshots Folder
	public String getcurrentdateandtime()
	{
		String str = null;
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str= dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		}
		catch(Exception e)
		{
		}
		return str;
	}
}