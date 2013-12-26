package com.vtiger.GenericPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Trail {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
		//driver.manage().timeouts().implicitlyWait(5000, TIMESE);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("India");
		driver.findElement(By.name("company")).sendKeys("IBM");
		driver.findElement(By.name("button")).click();
		
	}

}
