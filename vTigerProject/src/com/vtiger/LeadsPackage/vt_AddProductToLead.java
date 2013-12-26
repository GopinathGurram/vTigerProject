package com.vtiger.LeadsPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.vtiger.Libraries.Generic;
import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class vt_AddProductToLead extends SuperTestNG {
	@Test
	public void testvt_AddProductToLead() throws InterruptedException
	{
		String xlPath ="./testdata/vt_CreateLead.xlsx";
		String sheetName = "sheet1";
		
		String un=Generic.getXLCelval(xlPath, sheetName, 1, 0);
		System.out.println("Username:"+un);
		String pw=Generic.getXLCelval(xlPath, sheetName, 1, 1);			
		ProjectSpecificMethods.login( un, pw);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);					
		ProjectSpecificMethods.clickonTab("Leads");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ProjectSpecificMethods.addProductToLead();
		ProjectSpecificMethods.Logout();
		
	}

}
