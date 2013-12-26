package com.vtiger.HomePage;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.vtiger.Libraries.ProjectSpecificMethods;
import com.vtiger.Libraries.SuperTestNG;

public class vt_Calender extends SuperTestNG{
	@Test
	public static void testvt_Calender() throws InterruptedException{
		 /*Calendar cal = Calendar.getInstance();
         int curDay=cal.get(Calendar.DAY_OF_WEEK);
         int curDate=cal.get(Calendar.DATE); 
         if (curDay == 1) {
                 curDate=curDate+1;
         }
         else if (curDay == 7){
                 curDate=curDate+2;
         }
         */
		
		ProjectSpecificMethods.login("admin", "admin");
		driver.findElement(By.xpath("//img[@alt='Open Calendar...']")).click();
		
		//To click the calendar of current date
		String intdate = new SimpleDateFormat("dd").format(new Date());
		System.out.println(intdate);  	  	    
		Reporter.log("Clicking the current Date: "+intdate, true);
		driver.findElement(By.linkText(intdate)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement add = driver.findElement(By.xpath("//td[@class='calAddButton']"));
		ProjectSpecificMethods.toMouseOverOnElement(add);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Meeting")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.name("subject")).sendKeys("Meeting");
		
		Select select=new Select(driver.findElement(By.name("availableusers")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//input[1][@value='Add >>']")).click();
		driver.findElement(By.name("eventsave")).click();
		
		
		ProjectSpecificMethods.Logout();
	}

}

