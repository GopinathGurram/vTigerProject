package com.vtiger.LeadsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class vt_SearchLeadByAlpha extends SuperTestNG {
	@Test
	public void testvt_SearchLeadByAlpha() throws InterruptedException
	{
		ProjectSpecificMethods.login("admin", "admin");
		driver.findElement(By.linkText("Leads")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		ProjectSpecificMethods.searchLeadByAlpha("B");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//ProjectSpecificMethods.Logout();
	}
}
