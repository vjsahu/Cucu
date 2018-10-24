package com.zephyr.reusablemethods;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.pom.ReleasePage_POM;

public class ReleasePage extends ReleasePage_POM
{
	WebDriver driver;
	BasePage bp;
	
	public Logger log;
	public ReleasePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
		
    }


	/* ****************************************************
	   * Method Name   : clickOnTestRep()
	  * Purpose    : To click On TestRepository
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean clickOnTestRep() throws Exception
	 {
	  try
	  {
	   try
	   {
//	    boolean st2=testRepository.isEnabled();
//	 boolean st3=testRepository.isDisplayed();
	 //System.out.println(st2);
	 //System.out.println(st3);
	 
	 WebDriverWait wait1 = new WebDriverWait(driver, 30);
	    wait1.until(ExpectedConditions.elementToBeClickable(testRepository));
	    
	  }
	  
	  catch(TimeoutException e)
	     {
	    System.out.println("Inside Catch");
	      driver.navigate().refresh();
	      bp=new BasePage();
	         bp.waitForElement();
	         bp.waitForElement();
	         bp.waitForElement();
	     }
	   WebDriverWait wait1 = new WebDriverWait(driver, 30);
	      wait1.until(ExpectedConditions.elementToBeClickable(testRepository));
	    testRepository.click();
	    bp=new BasePage();
	    bp.waitForElement();
	    log.info("Successfully Landed on Test Repository Page");
	 
	 
	    String validate_TestRepository=validateRepository.getText();
	    String expmsg="Test Repository";
	    if(validate_TestRepository.equals(expmsg))
	   {
	     log.info("Successfully Landed on Test Repository Page");
	//    
	 }
	//    
	    else
	    {
	       log.info("You are not in Test Repository Page");
	   
	    }
	    return true;
	 }
	    catch(Exception e)
	    {
	     e.printStackTrace();
	     log.info("Test Repository is not Clicked");
	     throw e;
	     
	    }
	}	/* ****************************************************
	   * Method Name   : clickOnRequirements() 
	  * Purpose    : To click On Requirements
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean clickOnRequirements() throws Exception
	 {
		try
		{
	    boolean st4=requirements.isEnabled();
	 boolean st5=requirements.isDisplayed();
	 System.out.println(st4);
	 System.out.println(st5);
	 
	 //WebElement element1=driver.findElement(By.xpath("//a[@title='Test Repository']"));
	 WebDriverWait wait1 = new WebDriverWait(driver, 30);
	    wait1.until(ExpectedConditions.elementToBeClickable(requirements));
	    requirements.click();
	    bp=new BasePage();
	    bp.waitForElement();
	    log.info("Successfully Landed on Requirements Page");
	
	 
	    String validate_Requirements=validateRequirements.getText();
	    String expmsg="Requirements";
	    if(validate_Requirements.equals(expmsg))
	    {
	     	log.info("Successfully Landed on Test Requirement Page");
	     
	 	}
	     
	     else
	     {
	    	   log.info("You are not in Test Requirement Page");
	    
	     }
	    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 
	}
	
	public boolean clickOnManageRelease() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   bp.waitForElement();
	   bp.explicitWait(clickOnManageRelease);
	   clickOnManageRelease.click();
	   bp.waitForElement(); 
	//   String validate_TestExecution=clickOnManageRelease.getText();
	//   String expmsg="Manage Release";
	//   if(validate_TestExecution.equals(expmsg))
	//   {
//	    System.out.println("sucessfully clicked on Manage Release");  
	//   }  
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   
	   throw e;
	  }
	 }
	
	public boolean checkAvailableRelease(String releaseName) throws Exception
	{
	try
		{
	      try
			{
	    	  ReleasePage rp=new ReleasePage(driver);
	   WebElement relaeseName_1=driver.findElement(By.xpath(rp.release1+releaseName+rp.release2));
	  
	  boolean res=relaeseName_1.isDisplayed();
	 
	  String relaeseNameText=relaeseName_1.getText();
	 
	  if(releaseName.equals(relaeseNameText))
	    {
		  System.out.println(releaseName+"- already present in project");
	    }
	  
	    }
	   
	    catch(NoSuchElementException e)
		{
			System.out.println(releaseName+" is not present");
			return false;
			
		}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}


	}
	
	 public boolean enterStartDatAndEndDateForRelease(String syear,String smonth,String sday,String eyear,String emonth,String eday) throws Exception
	  {
	  try
	  {
	   bp=new BasePage();
	    startDateOption.click();
	    System.out.println("clicked on date option");
	    bp.waitForElement();
	    WebElement ele=driver.findElement(By.xpath(startDateHeader));
	    Actions a2=new Actions(driver);
	    a2.moveToElement(ele).doubleClick().perform();
	    driver.findElement(By.xpath(startDateHeader)).click();
	    //a2.moveToElement(ele).click().perform();
	    bp.waitForElement();
		  String []  startDate =new String[1];
		  String startYear=minYear.getText();
		  int Syear=Integer.parseInt(startYear);
		  int [] start=new int[1];
		  startDate[0]=syear;
		  start[0]=Integer.parseInt(startDate[0]);
			
			if(start[0] < Syear)
			{
				left.click();
				bp.waitForElement();
				
			}
			
			
			
	    
	    driver.findElement(By.xpath(year1+syear+year2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(month1+smonth+month2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(day1+sday+day2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    
	    endDateOption.click();
	    bp.waitForElement();
	    WebElement ele1=driver.findElement(By.xpath(endDateHeader));
	    Actions a3=new Actions(driver);
	    a3.moveToElement(ele1).click().perform();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(endDateHeader)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    String []  endDate =new String[1];
		  String endMin=minYear.getText();
			String endMax=maxYear.getText();
			int eMin=Integer.parseInt(endMin);
			int eMax=Integer.parseInt(endMax);
			int [] end=new int[1];
			endDate[0]=eyear;
			end[0]=Integer.parseInt(endDate[0]);
			
			if(end[0] < eMin)
			{
				left.click();
				bp.waitForElement();
			}
			else if(end[0] > eMax)	
			{
				right.click();
			    bp.waitForElement();
			}
	    
	    driver.findElement(By.xpath(year1+eyear+year2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    driver.findElement(By.xpath(month1+emonth+month2)).click();
	    bp.waitForElement();
	    bp.waitForElement();
	    driver.findElement(By.xpath(day_1+eday+day_2)).click();
	    bp.waitForElement();
	    return true;
	  }
	  
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  System.out.println("Release date is not enterd");
	  throw e;
	 }
	 } 
	
	 public boolean addNewRelease(String ReleaseName,String Desc,String Hide,String MapexternalDefect) throws Exception
	 {
	  try
	  {
	   
	   clickOnAddNewRelease.click();
	   bp.waitForElement();
	   System.out.println("sucessfully clicked on Add new Release"); 
	   
	   addNewReleaseContinue.click();
	   bp.waitForElement();
	   System.out.println("sucessfully clicked on Continue"); 
	   
	   enterReleaseName.sendKeys(ReleaseName);
	   bp.waitForElement();
	   System.out.println("Entered Release Name is : "+ReleaseName); 
	   
	   enterReleaseDescription.sendKeys(Desc);
	   bp.waitForElement();
	   System.out.println("Entered Desccription is : "+Desc);
	   
	   if(Hide!="")
	   {
	    boolean bol=releaseHide.isSelected();
	    if(bol==false)
	    {
	     releaseHide.click();
	     bp.waitForElement();
	    }
	   }
	   if(MapexternalDefect!="")
	   {
	    Select sel=new Select(mapExternalDefect);
	    sel.selectByVisibleText(MapexternalDefect);
	    bp.waitForElement();
	    System.out.println("Selected Defect is : "+MapexternalDefect); 
	   }
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   
	   throw e;
	  }
	 }
	 
	 public boolean clickOnAdd() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   clickOnAdd.click();
	   bp.waitForElement();
	   System.out.println("Pass-Release Sucessfully Created");
	//   String validate_TestExecution=clickOnManageRelease.getText();
	//   String expmsg="Manage Release";
	//   if(validate_TestExecution.equals(expmsg))
	//   {
//	    System.out.println("sucessfully clicked on Manage Release");  
	//   }  
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   System.out.println("Release not Created");
	   throw e;
	  }
	 }
}