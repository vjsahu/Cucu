package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Teststeps_809273 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTeststeps_809273";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	
	@Given("^User moves to the TestRepository$")
	public void user_moves_to_the_TestRepository() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();  
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

	@When("^User moves to ReleaseName$")
	public void user_moves_to_ReleaseName() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
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

	@When("^User navigates to Phasename$")
	public void user_navigates_to_Phasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",26,0);
		String desc=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",26,0);
		
		tr.addNode(name, desc);
		actual[4]=tr.doubleClickOnRelease(releaseName);
	     bp.waitForElement();
	     String navigation[]=new String[1];
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",26,0);
	     actual[5]=tr.navigateToNode(releaseName, navigation);
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

	@When("^User Selects Testcasename$")
	public void user_Selects_Testcasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String names[]=new String[1];
	     names[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",4,2);
	     //tr.selectTestCase(names);
	     actual[6]=tr.addTestCase();
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

	@When("^User Clicks on Details view$")
	public void user_Clicks_on_Details_view() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		actual[7]=tr.clickOnDetails();
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

	@When("^User Moves to StepDetails and Edit the TestSteps$")
	public void user_Moves_to_StepDetails_and_Edit_the_TestSteps() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		
		
		String steps[]=new String[6];
		steps[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 0);
		steps[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 1);
		steps[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 2);
		
		steps[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 0);
		steps[4]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 1);
		steps[5]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 2);
		
		ctc.enterTestCaseStepDetail(steps);
		bp.waitForElement();
		bp.waitForElement();
		ctc.stepDetail.click();
		
		bp.waitForElement();
		int stepNum=Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0);
		String edit[]=new String[3];
		edit[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 1);
		edit[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 2);
		edit[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 3);
		actual[8]=ctc.editTestSteps(stepNum, edit);
		
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

	@Then("^Teststeps should be Edited Successfully$")
	public void teststeps_should_be_Edited_Successfully() throws Throwable 
	{
		try
		{
	    log.info("Pass - Teststeps should be Edited Successfully");
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
