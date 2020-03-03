package Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

public class BasePage {

	DesiredCapabilities cap = new DesiredCapabilities();	
	public WebDriver driver;

	public WebDriver LaunchBrowser() throws Exception
	{
		cap.setCapability("deviceName","ZY322HJCVM");
		cap.setCapability("platformName","Android");
		cap.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(CapabilityType.VERSION,"8.1.0");
		cap.setCapability("chromedriverExecutable","C:\\Users\\user\\Desktop\\chromedriver.exe");		
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		System.out.println("Hello Appium");	
		driver.get("chrome://settings/clearBrowserData");
		driver.get("https://www.ultimatix.net");
		return driver;
	}

	public void takeScreenShot() throws Throwable{
		Date d = new Date();        
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		String cucumberfilePath = "target" + File.separator + "cucumber-reports" + File.separator +"cucumber_reports" + File.separator + screenshotFile;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
		try {
			FileUtils.copyFile(scrFile, new File(cucumberfilePath));
		} catch (IOException e) {        
			e.printStackTrace();
		}
		Reporter.addScreenCaptureFromPath("cucumber_reports" + File.separator + screenshotFile);
	}
	 public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
		    //Create an object of File class to open xlsx file
		    File file =    new File(filePath+"\\"+fileName);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook excelname = null;
		    //Find the file extension by splitting file name in substring  and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		   
		    //Check condition if the file is xls file
		     if(fileExtensionName.equals(".xls")){
		        //If it is xls file then create object of HSSFWorkbook class
		    	excelname = new HSSFWorkbook(inputStream);
		    	System.out.println("excelname"+excelname);
		    }
		    //Read sheet inside the workbook by its name
		    Sheet sheetname = excelname.getSheet(sheetName);
		    System.out.println("sheetname"+sheetname);
		    //Find number of rows in excel file
		    int rowCount = sheetname.getLastRowNum()-sheetname.getFirstRowNum();
		    //Create a loop over all the rows of excel file to read it
		    for (int i = 0; i < rowCount+1; i++) {
		        Row row = sheetname.getRow(i);
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            //Print Excel data in console
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        }
		        System.out.println();
		    } 

		    }  


}




