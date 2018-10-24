package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

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

public class Edit_As_CUser_AddTestSteps_809318 extends LaunchBrowser
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
	String fileName="Edit_809318";
	
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the TestRepo Page$")
	public void user_is_in_the_TestRepo_Page() throws Throwable 
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

	@When("^User Clicks on Release$")
	public void user_Clicks_on_Release() throws Throwable 
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
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Creates Phase in Release$")
	public void user_Creates_Phase_in_Release() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
		     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		     actual[4]=tr.addNode(Name, Desc);
		     bp.waitForElement();
		     String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		     tr.doubleClickOnRelease(releaseName);
		     String navigation[]=new String[1];
		     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     actual[5]=tr.navigateToNode(releaseName, navigation);
		     bp.waitForElement(); 

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

	@When("^User Adds Testcase in the Created phase$")
	public void user_Adds_Testcase_in_the_Created_phase() throws Throwable 
	{
	    try
	    {
	    	actual[6]=tr.addTestCase();
			 bp.waitForElement();
			 actual[7]= tr.clickOnDetails();
			 bp.waitForElement();
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

	@When("^User Adds Steps to the Testcase$")
	public void user_Adds_Steps_to_the_Testcase() throws Throwable 
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
			actual[8]=ctc.enterTestCaseStepDetail(stepDetails);
		    bp.waitForElement();
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

	@Then("^Teststeps should be Added Successfully in the Testcase$")
	public void teststeps_should_be_Added_Successfully_in_the_Testcase() throws Throwable 
	{
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
	        {
	         soft.assertEquals(actual[k], true);
	        }
	        soft.assertAll();
	        
	    	log.info("Pass - Teststeps should be Added Successfully in the Testcase");
	    	tr.clickOnList();
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
