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

public class Edit_Reset_MultiTeststeps_808927 extends LaunchBrowser
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
	String fileName="Edit_Reset_MultiTeststeps_808927";
	
	@Given("^User is Present in the TestRepositoryPage$")
	public void user_is_Present_in_the_TestRepositoryPage() throws Throwable 
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

	@When("^User Creates Phase$")
	public void user_Creates_Phase() throws Throwable 
	{
		try
	    {
	    	bp=new BasePage();
			tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		     tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     //bp=new BasePage();
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

	@When("^User Adds one Testcase$")
	public void user_Adds_one_Testcase() throws Throwable 
	{
		try
		{
		 tr.addTestCase();
		 bp.waitForElement();
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

	@When("^User Adds Multiple TestSteps for the Testcases$")
	public void user_Adds_Multiple_TestSteps_for_the_Testcases() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		String stepDetails[]=new String[6];
		stepDetails[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,11);
		stepDetails[1]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,12);
		stepDetails[2]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,13);
		stepDetails[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 1);
		stepDetails[4]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 2);
		stepDetails[5]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 3);
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

	@When("^User Resets the Multiple Testcases$")
	public void user_Resets_the_Multiple_Testcases() throws Throwable 
	{
	    try
	    {
	    	int stepNum=Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0);
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

	@Then("^Multiple TestSteps should be Reset Successfully$")
	public void multiple_TestSteps_should_be_Reset_Successfully() throws Throwable 
	{
		try
		{
			log.info("Pass - Multiple TestSteps should be Reset Successfully");
			
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
