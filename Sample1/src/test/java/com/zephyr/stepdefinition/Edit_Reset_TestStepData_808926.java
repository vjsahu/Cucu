package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Reset_TestStepData_808926 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	NavigationPage np;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_Reset_TestStepData_808926";
	
	@Given("^User Presents in the TestPageRepository$")
	public void user_Presents_in_the_TestPageRepository() throws Throwable 
	{
		try
		{
//			lb=new LaunchBrowser();
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   pp.selectProject(projectName);
			   pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   rp.clickOnTestRep();
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

	@When("^User Creates a phase$")
	public void user_Creates_a_phase() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
			tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		     tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     bp=new BasePage();
		     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		     tr.addNode(Name, Desc);
		     bp.waitForElement();
		     tr.doubleClickOnRelease(releaseName);
		     String navigation[]=new String[1];
		     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     tr.navigateToNode(releaseName, navigation);
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

	@When("^User Adds Testcase to the Phase$")
	public void user_Adds_Testcase_to_the_Phase() throws Throwable 
	{
		try
		{
			 tr.addTestCase();
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

	@When("^User Clicks on detail view$")
	public void user_Clicks_on_detail_view() throws Throwable 
	{
		try
		{
			tr.clickOnDetails();
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

	@When("^User Adds Teststeps in StepDetails$")
	public void user_Adds_Teststeps_in_StepDetails() throws Throwable 
	{
		try
		{
			ctc=new CreateTestCasePage(driver);
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 1);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 2);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 3);
		    ctc.enterTestCaseStepDetail(stepDetails);
		    bp.waitForElement();
		    ctc.stepDetail.click();
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

	@When("^User Resets only TestData and Saves it$")
	public void user_Resets_only_TestData_and_Saves_it() throws Throwable 
	{
		try
		{
			ctc=new CreateTestCasePage(driver);
			int stepNum=Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1);
			String edit[]=new String[3];
			edit[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 1);
			edit[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 2);
			edit[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 3);
		    ctc.resetTeststeps(stepNum, edit);
		    
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

	@Then("^TestData should be Reset Successfully$")
	public void testdata_should_be_Reset_Successfully() throws Throwable 
	{
		try
		{
			log.info("Pass - TestData should be Reset Successfully");
			
			bp.waitForElement();
		    ctc.stepDetail.click();
		    bp.waitForElement();
			
			tr.clickOnList();
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
