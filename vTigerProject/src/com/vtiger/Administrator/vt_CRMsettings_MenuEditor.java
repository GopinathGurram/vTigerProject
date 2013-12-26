package com.vtiger.Administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class vt_CRMsettings_MenuEditor extends SuperTestNG{
	@Test
	public static void testvt_CRMsettings_MenuEditor() throws InterruptedException{
		ProjectSpecificMethods.login("admin", "admin");		
		ProjectSpecificMethods.crmSetting("Reports");
		ProjectSpecificMethods.Logout();
		driver.close();
		ProjectSpecificMethods.login("admin", "admin");
		WebElement moreElement=driver.findElement(By.linkText("More"));
		ProjectSpecificMethods.toMouseOverOnElement(moreElement);
		
		if (driver.findElement(By.linkText("Reports")).isDisplayed()){
			Reporter.log("The expected tab is added", true);			
		}else{
			Reporter.log("The expected tab is not added", true);
		}
			
		//to remove the settings 
		ProjectSpecificMethods.toRemovetheSettings("Reports");
		
		
		
	}

}
