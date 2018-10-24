package com.zephyr.reusablemethods;



import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.NavigationaPage_POM;
public class NavigationPage extends NavigationaPage_POM 
{
	BasePage bp;
  public Logger log;
	public WebDriver driver=null;
	 
	 public NavigationPage(WebDriver driver)
    {
		super(driver);
		this.driver = LaunchBrowser.driver;
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
	 }
	 
	 
		public boolean checkingBreadCrumbs(String[] Phases) throws Exception
		{
			

//		String[] Phase=new String[4];
//		Phase[0]="Release 1.0";
//		Phase[1]="ABA";
//		Phase[2]="System1";
//		Phase[3]="Subsystem1";
	try
			{
		BasePage bp=new BasePage();
		bp.waitForElement();
	 	String str2=breadCrumbs.getText();
	 	System.out.println(str2);
		
		String[] parts=str2.split(" > ");	
		boolean value=false;
		for(int i=0;i<=parts.length-1;i++)
		{
		      value=false;
			if(parts[i].equals(Phases[i]))
			{
				value=true;
			}
		}
		if(value==true)
		{
			System.out.println("BreadCrumbs are Verified");
		}
		else
		{
			System.out.println("BreadCrumbs are not Verified");
		}
		return true;
			}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
		
		}
	
		public boolean searchDropDown() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			prevSearchDropDown.click();
			bp.waitForElement();
			clickOnPreviousSearch.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}


		public boolean navigatingPageNumbers() throws Exception
		{
			try
			{
			clickOnPage2.click();
			clickOnPage3.click();
			clickOnPage4.click();
			clickOnPage5.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		
		public boolean searchAndAdd(String searchOption) throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			clickOnSearch.click();
			WebDriverWait wait=new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(clickOnSearch));
			bp.waitForElement();
			bp.waitForElement();
			advancedSearch.click();
			WebDriverWait wait2=new WebDriverWait(driver, 100);
			wait2.until(ExpectedConditions.elementToBeClickable(advancedSearch));
			bp.waitForElement();
			//clickOnSearchTextArea.click();
			advancedSearchTextArea.sendKeys(searchOption);
			bp.waitForElement();
			
			clickOnGo.click();
			bp.waitForElement();
			//clickOnRelease.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}

	
	
///////////////added 26-7-2017/////////////////////	
	public boolean verifySearchResult(String zql) throws Exception
	{
		try
		{
		//priority verification		
		List<WebElement> all=driver.findElements(By.xpath("//*[@id='grid-table-tcr']/div[2]/div/div[11]/div/div"));
		boolean res=false;
		for(int i=0;i<all.size();i++)
		{
			res=false;
			if(zql.equalsIgnoreCase(all.get(i).getText()));
			{
				res=true;
			}
		}
	
		
		
		if(res==true)
		{
			log.info("elements are matching");
		}
		return true;
	}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//String txt=searchTestCaseText.getText();
		//System.out.println(txt);
		
//		if(zql.equals(txt))
//		{
//			log.info("should generate detailed Filter by just creation start date with coverage");
//		}
		
	}
	
	///////////added//////
	public boolean quiksearch(String Priority) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSearch));
		clickOnSearch.click();
		bp.waitForElement();
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSearchTextArea));
		clickOnSearchTextArea.sendKeys(Priority);
		bp.waitForElement();
		clickOnGo.click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}
	}

	
	/*	****************************************************
	 * Method Name			: selectpreviousSearch(String operator,String zql)
	 * Purpose				: To Click on the previous search in the test repository page
	 * Author				: OPAL4
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: OPAL2
	 * ******************************************************
	*/
	public boolean selectpreviousSearch(String operator,String zql) throws Exception
	{
		try
		{
		//String value=operator+zql;
		bp=new BasePage();
		bp.waitForElement();
//		prevSearchDropDown.click();
		//bp.waitForElement();
		//clickOnPreviousSearch.click();
		 String expRes;
		
		if(operator.equals("id="))
		{
			String value1=operator+zql;
			Select sel= new Select(previousSearch);
			sel.selectByValue(value1);
		List<WebElement> all=driver.findElements(By.xpath(".//*[@id='grid-table-tcr']/div[2]/div/div[3]/div/div"));
		boolean res=false;
		for(int i=0;i<all.size();i++)
		{
			res=false;
			if(zql.equals(all.get(i)));
			{
				res=true;
			}
		}
		if(res==true)
		{
			log.info("elements are matching");
		}
		
		}
		
		
		
		if(operator.equals("creator="))
		{
		
			//System.out.println(zql);
			String p= "\"" + zql + "\"";
			//System.out.println(p);
			//String q= " \+"zql\+";
		    String value2=operator+p;
		    //System.out.println(value2);
		    Select sel= new Select(previousSearch);
			sel.selectByValue(value2);
		    if(zql.equals("test.lead"))
		    {
		     expRes="Test Lead";
		    	bp=new BasePage();
		    	bp.waitForElement();
		   List<WebElement> all=driver.findElements(By.xpath(".//*[@id='grid-table-tcr']/div[2]/div/div[11]/div/div"));
		  // System.out.println(all.get(0).getText());
		   
		   boolean res=false;
		  for(int i=0;i<=all.size()-1;i++)
		   {
			  String actRes=all.get(i).getText();
			  
			res=false;
			
			if(expRes.equals(actRes));
			{
				Actions a2=new Actions(driver);
				//a2.sendKeys(Keys.DOWN).perform();
				res=true;
			}
		   }
		if(res==true)
		{
			log.info("elements are matching");
		}
		
		}
	}
		
		if(operator.equals("name~"))
		{
			String p= "\"" + zql + "\"";
			
		    String value3=operator+p;
		    System.out.println(value3);
		    Select sel= new Select(previousSearch);
			sel.selectByValue(value3);
		}
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}
		}
		
	
	public boolean sortInSearchResult(String[] sortName) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath("//div[@class='flex-header-item column-chooser-parent dont-sort custom-column-chooser']//a"));
	    Actions a1=new Actions(driver);
	    a1.moveToElement(ele).click().perform();
		bp.waitForElement();
		
		/*
		String sort1="//label[@title='";
		String sort2="']/..//input";*/
		for(int i=0;i<=sortName.length-1;i++)
		{
		WebElement ele1=driver.findElement(By.xpath("//label[@title='Priority']"));
		
		boolean res=ele1.isSelected();
		
		if(res==false)
		{
			a1.moveToElement(ele1).click().perform();
		}
		}
		bp.waitForElement();
		a1.moveToElement(ele).click().perform();
		bp.waitForElement();
		
		return true;
		
	
	}
	catch (Exception e) {
		e.printStackTrace();
		throw e;

	}
}
	
      
}



