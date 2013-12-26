package com.vtiger.Libraries;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

//import com.thoughtworks.selenium.Wait;


	public class ProjectSpecificMethods extends SuperTestNG{
		//1. Login
		public static void login(String un,String pw) throws InterruptedException{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.name("user_name")).clear();
			driver.findElement(By.name("user_password")).clear();
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pw);
			driver.findElement(By.id("submitButton")).click();
			Reporter.log("Login button is clicked", 1);
			Thread.sleep(5);
		}		
	
		//2.Logout
		public static void Logout() throws InterruptedException
		{
			WebElement signout= driver.findElement(By.xpath("//tr/td[2]/img"));
			toMouseOverOnElement(signout);			
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(5);
		}
		
		//3.create Leads
		public static void createLead()
		{
			driver.findElement(By.linkText("Leads")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
			//select = new Select(driver.findElement(arg0))
		}	
		
		//4. Adding products to exisiting Lead
		public static void addProductToLead()
		{
			//Click the available first lead from the table
			driver.findElement(By.xpath("//tr[3]/td[3]/a")).click();			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Reporter.log("The First Lead Link is clicked", 1);
			driver.findElement(By.linkText("More Information")).click();
			Reporter.log("More Information Link is clicked", 1);
			driver.findElement(By.id("show_Leads_Products")).click();
			Reporter.log("Products Link is clicked", 1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//input[@value='Select Products']")).click();
			Reporter.log("Select Products button is clicked", 1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 Iterator <String> allWH = driver.getWindowHandles().iterator();
		     String parentWH = allWH.next();
		     String childWH =  allWH.next();
		
		     driver.switchTo().window(childWH);
		   //	To click the first product from the table of Products page				
		     driver.findElement(By.xpath("//tr[2]/td[2]/a")).click();
		     
		     Generic.explicitWait(3);
		     driver.switchTo().window(parentWH);			
		}
		
		//
		public static void searchLeadByAlpha(String alpha)
		{
			toClickAlpha(alpha);
			String fName=driver.findElement(By.xpath("//tr[3]/td[3]/a")).getText();
			System.out.println(fName);
			if (fName.substring(1, 1).equals(fName)){
				Reporter.log("Search matches", true);
			}
		}
		
		public static void toClickAlpha(String alpha)
		{
			switch(alpha)
			{
			case "A":
				driver.findElement(By.id("alpha_1")).click();
				break;
			case "B":
				driver.findElement(By.id("alpha_2")).click();
				break;
			case "C":
				driver.findElement(By.id("alpha_3")).click();
				break;
			case "D":
				driver.findElement(By.id("alpha_4")).click();
				break;
			case "E":
				driver.findElement(By.id("alpha_5")).click();
				break;
			case "F":
				driver.findElement(By.id("alpha_6")).click();
				break;
			case "G":
				driver.findElement(By.id("alpha_7")).click();
				break;
			case "H":
				driver.findElement(By.id("alpha_8")).click();
				break;
			case "I":
				driver.findElement(By.id("alpha_9")).click();
				break;
			case "J":
				driver.findElement(By.id("alpha_10")).click();
				break;
			case "K":
				driver.findElement(By.id("alpha_11")).click();
				break;
			case "L":
				driver.findElement(By.id("alpha_12")).click();
				break;
			case "M":
				driver.findElement(By.id("alpha_13")).click();
				break;
			case "N":
				driver.findElement(By.id("alpha_14")).click();
				break;
			case "O":
				driver.findElement(By.id("alpha_15")).click();
				break;
			case "P":
				driver.findElement(By.id("alpha_16")).click();
				break;
			case "Q":
				driver.findElement(By.id("alpha_17")).click();
				break;
			case "R":
				driver.findElement(By.id("alpha_18")).click();
				break;
			case "S":
				driver.findElement(By.id("alpha_19")).click();
				break;
			case "T":
				driver.findElement(By.id("alpha_20")).click();
				break;
			}
		}
		
		//Verify Title
		public static void verifyTitle(String eTitle)
		{
			Generic.explicitWait(3);
			String aTitle=driver.getTitle();
			Assert.assertEquals(aTitle, eTitle);
		}	
		
		//To click on any tab/module
		public static void clickonTab(String tabName)
		{
			driver.findElement(By.linkText(tabName)).click();
			Reporter.log("The tab: "+tabName+" is availabe and clicked", true);;
		}
	
		//
		public static void createnewLead(String fname, String lname, String comp, String assignTo)
		{
			driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
			Select select;
			select = new Select(driver.findElement(By.name("salutationtype")));
			select.selectByValue("Mr.");
			driver.findElement(By.name("firstname")).sendKeys(fname);
			driver.findElement(By.name("lastname")).sendKeys(lname);
			driver.findElement(By.name("company")).sendKeys(comp);
			if (assignTo.equals("User"))
			{
					driver.findElement(By.xpath("//input[@value='T']")).click();
					
			}			
		}
		
		//To move the mouse over an element
		public static void toMouseOverOnElement(WebElement element){
			Actions actions=new Actions(driver);
			actions.moveToElement(element).build().perform();
		}
		
		public static void crmSetting(String tabName)
		{
			WebElement settings=driver.findElement(By.xpath("//tr/td[4]/img"));
			toMouseOverOnElement(settings);
			driver.findElement(By.linkText("CRM Settings")).click();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Menu Editor")).click();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			Select select;
			select = new Select(driver.findElement(By.name("availList")));
			select.selectByVisibleText("Reports");			
			Reporter.log("Save button clicked", true);
			driver.findElement(By.xpath("//img[@title='right']")).click();
			Reporter.log("Right Arrow button clicked", true);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='save']")).click();
			Reporter.log("Save button clicked", true);				
		}
		
		
		public static void toSelectList(String elementname, String elemval)
		{
			Select select;
			select = new Select(driver.findElement(By.name(elementname)));
			select.selectByVisibleText(elemval);
			
		}
		
		
		public static void toRemovetheSettings(String tabName)
		{
			WebElement settings=driver.findElement(By.xpath("//tr/td[4]/img"));
			toMouseOverOnElement(settings);
			driver.findElement(By.linkText("CRM Settings")).click();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Menu Editor")).click();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			Select select;
			select = new Select(driver.findElement(By.name("availList")));
			select.selectByVisibleText(tabName);			
			Reporter.log("Save button clicked", true);
			driver.findElement(By.xpath("//img[@title='left']")).click();
			Reporter.log("Right Arrow button clicked", true);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='save']")).click();
			Reporter.log("Save button clicked", true);				
		}
		
		
		
	}


