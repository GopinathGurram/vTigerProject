package com.vtiger.Libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic {
	
	//Retrieve the exl row count
	public static int getXLRowCount(String xlPath, String shtName)
	{
		int rowCount;
		try
		{
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(shtName);
			rowCount = sh.getLastRowNum();
			System.out.println(rowCount);
		}catch(Exception e)
		{
			rowCount=-1;
		}
		return rowCount;
	}

	
	//Return the cell value
	public static String getXLCelval(String xlPath,String shtName, int rowNum,int celNum)
	{
		String val;
		FileInputStream fis;
		try
		{
			fis = new FileInputStream(xlPath);	
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(shtName);
			val = sh.getRow(rowNum).getCell(celNum).getStringCellValue();
			System.out.println(val);
			
		}catch(Exception e)
		{
			val="";
		}
		return val;
	}

	public static void explicitWait(int sec){
		try
		{
			Thread.sleep(sec*1000);
		}
		catch(InterruptedException e)
		{
		}
	
		}

	



}

