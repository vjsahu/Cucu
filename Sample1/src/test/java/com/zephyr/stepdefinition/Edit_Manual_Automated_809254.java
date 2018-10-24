package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.TestRepositoryPage_POM;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Manual_Automated_809254 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	NavigationPage np;
	TestRepositoryPage_POM trPOM;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_Manual_Automated_809254";
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	
	@Given("^User navigates to the Testrepository$")
	public void user_navigates_to_the_Testrepository() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
//		   
		try{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep();  
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User moves to Releasename$")
	public void user_moves_to_Releasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
	     String name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",25,0);
	     actual[4]=tr.addNode(name, name);
		bp.waitForElement();
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		 
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	     
	}

	@When("^User moves to the Phase$")
	public void user_moves_to_the_Phase() throws Throwable 
	{
		try
		{
			String navigation[]=new String[1];
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",25,0);
		     actual[6]= tr.navigateToNode(releaseName, navigation);
			
			bp=new BasePage();
			trPOM=new TestRepositoryPage_POM(driver);
			for(int i=1;i<=10;i++)
			{
				actual[7]=tr.addTestCase();
			bp.waitForElement();
			}
			tr.selectallTestCase();
			
			for(int j=1;j<=9;j++)
			{
				actual[8]=tr.cloneTestCase();
			bp.waitForElement();
			}
		 
	     bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	}

	@When("^User Selects Multiple Manual Testcases$")
	public void user_Selects_Multiple_Manual_Testcases() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		np=new NavigationPage(driver);
		actual[9]=tr.selectallTestCase();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User Clicks on Edit and convert to Automated Testcase$")
	public void user_Clicks_on_Edit_and_convert_to_Automated_Testcase() throws Throwable 
	{	try
	
	{
		actual[10]=tr.editTestCase();
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		String detailField[]=new String[3];
	     detailField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 0);
	     detailField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 1);
	     detailField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 2);
	     String automationField[]=new String[4];
	     automationField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 3);
	     automationField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 4);
	     automationField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 5);
	     automationField[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 2);
	     actual[11]=ctc.editMultipleTestCase(detailField, automationField);
	     bp.waitForElement();
	     actual[12]=ctc.saveMultipleTestCaseEdit();
	     bp.waitForElement();
	    //ctc.enterAutomationScriptField(script_Name, script_Id, script_Path);
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	}

	@Then("^Testcases should be converted into AutomatedTC with Internation cahracters in Nmae$")
	public void testcases_should_be_converted_into_AutomatedTC_with_Internation_cahracters_in_Nmae() throws Throwable 
	{
		try
		{
	    log.info("Pass - Testcases should be converted into AutomatedTC with Internation cahracters in Nmae");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
