package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

public class LoginPage extends BasePage{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterUserName() throws Exception
	{ 
		WebElement userName=driver.findElement(By.id("form1"));	 
		userName.click();
		userName.sendKeys("Aarthi.R");
		WebElement proceedBtn=driver.findElement(By.id("proceed-button"));
		proceedBtn.click();
	}
	public void enterPassword() throws Exception
	{  	
		WebElement passwordButton=driver.findElement(By.id("password-btn"));
		WebElement enterPassWord=driver.findElement(By.id("password-login"));
		passwordButton.click();
		enterPassWord.sendKeys("amc@20,MAR");
	}
	public void clickEnter() throws Exception
	{
		WebElement loginButton=driver.findElement(By.xpath("//*[@id='form-submit']"));
		loginButton.click();
		loginButton.click();
	}
	public void homePagePresence() throws Exception
	{ 	
		WebElement menuImage =driver.findElement(By.xpath("//*[@id='navbar-id']/div/div[1]/ul/li[1]/button"));	
		menuImage.click();
		Thread.sleep(2000);
		WebElement UserName =driver.findElement(By.xpath("//*[@id='myNav']/div/div[1]/div[1]/div[1]"));
		System.out.println("UserName is:"+UserName.getText());
		if(UserName.getText().contains("Aarthi"))
		{
			Reporter.addStepLog("Correct User Logged in"+UserName.getText());	
		}
		else
		{
			Assert.fail("Correct User Logged in"+UserName.getText());	
		}		
		Thread.sleep(2000);
		WebElement closeBtn =driver.findElement(By.xpath("//*[@id='myNav']/div/div[1]/div[2]"));
		closeBtn.click();	
		Thread.sleep(2000);

	}
	public void signOut() throws Exception
	{
		Thread.sleep(2000);
		WebElement logoffImage=driver.findElement(By.xpath("//*[@id='uam_modal']"));
		logoffImage.click();
		Thread.sleep(2000);
		WebElement logoffButton=driver.findElement(By.xpath("(//*[@id='uamlogoutMobileButton'])[1]"));
		logoffButton.click();
	}
}
