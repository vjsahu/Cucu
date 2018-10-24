package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_AllCustomFields_809199 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	CreateCustomFieldsPage ccf;
	String fileName="Create_AllCustomFields_809199";
	 
	  
	@Given("^Manager Login into Zephyr Application$")
	public void manager_Login_into_Zephyr_Application() throws Throwable 
	{
	    try
	    {
			lb=new LaunchBrowser();
			bp=new BasePage();
			   lb.preCond();
			   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "URL");
			   lb.getUrl(url);
			   lp=new LoginPage(driver);
			   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Manager_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Manager_Password_1");
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   bp.waitForElement();
//			   pp=new ProjectPage(driver);
//			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Project1");
//			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
//			   actual[0]=pp.selectProject(projectName);
//			   actual[1]=pp.selectRelease(releaseName);
//			   bp=new BasePage();
//			   rp= new ReleasePage(driver);
//			   actual[2]=rp.clickOnTestRep(); 
	    }
	    catch(Exception e)
		{
	    	  lb.getScreenShot(fileName);
			driver.close();
			
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Manager Navigates upto Testcase Fields in the Customizations Option$")
	public void manager_Navigates_upto_Testcase_Fields_in_the_Customizations_Option() throws Throwable 
	{
	    try
	    {
	    	ccf=new CreateCustomFieldsPage(driver);
	    	ccf.moveToCustomFields();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Manager Locks the Zephyr Acces for all other Users$")
	public void manager_Locks_the_Zephyr_Acces_for_all_other_Users() throws Throwable 
	{
	    try
	    {
	    	//ccf.lockZephyrAccess();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Manager Adds Custom field with Text$")
	public void manager_Adds_Custom_field_with_Text() throws Throwable 
	{
		try
    	  {
	    	
			String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,0);
			//CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
	    
	    	
	    	
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
				
	    		//String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,0);
		    	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,1);
		    	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,2);
		    	String piclistValues[]=new String[1];
		    	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
		    	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
		    	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",5,0);
		    	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,6);
		    	
		    	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	 //ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck);
	    	
	    	}
    	  }
			 catch(Exception e)
				{
				 lb.getScreenShot(fileName);
					driver.close();
					Relogin rl=new Relogin();
					rl.reLogin();
					throw e;
				}
	    }
	    
	

	@When("^Manager Adds Custom field with LongText$")
	public void manager_Adds_Custom_field_with_LongText() throws Throwable 
	{
	    try
	    {
	    	String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,0);
	    	//CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
	    	//boolean result=driver.findElement(By.xpath(cctp.custom1+customfieldName+cctp.custom2)).isDisplayed();
	    	
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
				
				//String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,0);
		    	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,1);
		    	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,2);
		    	String piclistValues[]=new String[1];
		    	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
		    	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
		    	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,5);
		    	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,6);
		    	bp=new BasePage();
		    	bp.waitForElement();
		    	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	//ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck);
	    	}
             //boolean result=driver.findElement(By.xpath("//*[@title='CustomLongText']")).isDisplayed();
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	    }
	   
	

	@When("^Manager Adds Custom field with Picklist$")
	public void manager_Adds_Custom_field_with_Picklist() throws Throwable 
	{
	    try
	    {
	    	String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",3,0);
	    	//CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
	    	//boolean result=driver.findElement(By.xpath(cctp.custom1+customfieldName+cctp.custom2)).isDisplayed();
	    	
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
				
				//String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",3,0);
		    	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",3,1);
		    	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",3,2);
		    	String piclistValues[]=new String[2];
		    	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
		    	piclistValues[1]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,3);
		    	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
		    	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,5);
		    	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,6);
		    	bp.waitForElement();
		    	
		    	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	//ccf.createCustomFields(customfieldName, customfieldDescription, dataType,piclistValues, allProject, projectName, searchableCheck);
	    	}
			
            //boolean result=driver.findElement(By.xpath("//*[@title='CustomPicklist']")).isDisplayed();
	    }
	  catch(Exception e)
			{
		  lb.getScreenShot(fileName);
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	    }
	    
	

	@When("^Manager Adds Custom field with Checkbox$")
	public void manager_Adds_Custom_field_with_Checkbox() throws Throwable 
	{
	    try
	    {
	    	//CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
	    
	    	String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",4,0);
	    	//boolean result=driver.findElement(By.xpath(cctp.custom1+customfieldName+cctp.custom2)).isDisplayed();
	    	
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
				//String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",4,0);
		    	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",4,1);
		    	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",4,2);
		    	String piclistValues[]=new String[1];
		    	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
		    	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
		    	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,5);
		    	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,6);
		    	bp.waitForElement();
		    	
		    	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	// ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck);
	    	}
	    	
	    }//System.out.println(result);
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	    }
	    
		

	@When("^Manager Adds Custom field with Number$")
	public void manager_Adds_Custom_field_with_Number() throws Throwable 
	{
	    try
	    {
	    	//CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
		    
	    	String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",5,0);
	    	//boolean result=driver.findElement(By.xpath(cctp.custom1+customfieldName+cctp.custom2)).isDisplayed();
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
				//Strin
				//String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",5,0);
		    	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",5,1);;
		    	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",5,2);
		    	String piclistValues[]=new String[1];
		    	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
		    	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
		    	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,5);
		    	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,6);
		    	
		    	bp.waitForElement();
		    	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	//ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck);
	    	}
	    	
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	    		
	    }
	   
		

	@When("^Manager Adds Custom field with Date$")
	public void manager_Adds_Custom_field_with_Date() throws Throwable 
	{
	    try
	    {
	    	
            // CreateCustomFieldsPage_POM cctp=new CreateCustomFieldsPage_POM(driver);
		    
	    	String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",6,0);
	    	//boolean result=driver.findElement(By.xpath(cctp.custom1+customfieldName+cctp.custom2)).isDisplayed();
	    	
	    	boolean available=ccf.checkAvailableCustomFields(customfieldName);
			if(available==false)
			{
                    //String customfieldName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",6,0);
	    		
	        	String customfieldDescription=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",6,1);
	        	String dataType=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",6,2);
	        	String piclistValues[]=new String[1];
	        	piclistValues[0]=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,3);
	        	String allProject=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,4);
	        	String projectName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",1,5);
	        	String searchableCheck=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",2,6);
	        	
	        	bp.waitForElement();
	        	String unique=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
		    	String mandatory=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",99,6);
	    	 ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck,unique, mandatory);
	    	//ccf.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck);
	    	}//Strin
	    }
	    	
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	    }
	   
		

	@Then("^Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully$")
	public void custom_Fields_with_Text_LongText_Picklist_Checkbox_Number_Date_Should_be_created_Successfully() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
	    	//ccf.enableZephyrAccess.click();
	    	bp.waitForElement();
	    	ccf.closeCustomFieldWindow.click();
	    	bp.waitForElement();
	    	
	    	log.info("Pass - Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully");
	    }
	    catch(Exception e)
		{
	    	 lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}


}
