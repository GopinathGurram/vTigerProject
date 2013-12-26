package com.vtiger.LeadsPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.vtiger.Libraries.Generic;
import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class vt_CreateLead extends SuperTestNG{
	@Test	
	public void testvt_CreateLead() throws InterruptedException
	{
		String xlPath ="./testdata/vt_CreateLead.xlsx";
		String sheetName = "sheet1";
		//int rc=Generic.getXLRowCount(xlPath, sheetName);
		//for (int i = 0; i <=rc; i++) {
			String un=Generic.getXLCelval(xlPath, sheetName, 1, 0);
			System.out.println("Username:"+un);
			String pw=Generic.getXLCelval(xlPath, sheetName, 1, 1);
			//String homePage=Generic.getXLCelval(xlPath, sheetName, 1, 2);
			//String loginPage=Generic.getXLCelval(xlPath, shtName, i, 3);
			ProjectSpecificMethods.login( un, pw);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//ProjectSpecificMethods.verifyTitle(homePage);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ProjectSpecificMethods.clickonTab("Leads");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		//}
	}
}