package com.vtiger.Libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import com.vtiger.Libraries.*;


public class SuperTestNG 
{
	public static WebDriver driver;
	
	@BeforeMethod(groups={"mandatory"})
	public void precondition()
	{
		String xlPath="./testdata/Config.xlsx";
		String shtName="Sheet1";
		String brType=Generic.getXLCelval(xlPath, shtName, 0, 1);
		
		if(brType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./exe/chromedriver.exe");			
			driver = new ChromeDriver();
		}
		else if(brType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.IE.driver","./exe/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();			
		}else
		{
			 driver = new FirefoxDriver();			
		}		
		
		String url=Generic.getXLCelval(xlPath, shtName, 1, 1);
		Reporter.log("Navigating to URL:"+url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("Browser maximized");
	}

	
	
	//@AfterMethod(groups={"mandatory"})
	public void postcondition()
	{
		driver.quit();
		Reporter.log("Closing the Browser");
	}
	
	
	
}
