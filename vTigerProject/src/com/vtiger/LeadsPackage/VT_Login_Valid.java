package com.vtiger.LeadsPackage;

import org.testng.annotations.Test;

import com.vtiger.Libraries.Generic;
import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class VT_Login_Valid extends SuperTestNG{
	@Test	
	public void testVT_Login_Valid() throws InterruptedException
	{
		String xlPath ="./testdatas/VT_Login_Valid.xlsx";
		String sheetName = "sheet1";
		//int rc=Generic.getXLRowCount(xlPath, sheetName);
		//for (int i = 0; i <=rc; i++) {
		String un=Generic.getXLCelval(xlPath, sheetName, 1, 0);
		String pw=Generic.getXLCelval(xlPath, sheetName, 1, 1);
			String homePage=Generic.getXLCelval(xlPath, sheetName, 1, 2);
			//String loginPage=Generic.getXLCelval(xlPath, shtName, i, 3);
			
			ProjectSpecificMethods.login(un,pw);
			ProjectSpecificMethods.verifyTitle(homePage);
			//ProjectSpecificMethods.Logout();
			
		//}		
	}
	
}
