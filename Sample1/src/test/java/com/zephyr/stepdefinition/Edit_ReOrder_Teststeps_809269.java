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

public class Edit_ReOrder_Teststeps_809269 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_ReOrder_Teststeps_809269";
	
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the testrepopage$")
	public void user_is_in_the_testrepopage() throws Throwable 
	{
	    try
	    {
//			lb=new LaunchBrowser();
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",3,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",3,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
			   tr=new TestRepositoryPage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   actual[0]= pp.selectProject(projectName);
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

	@When("^User Moves to Releasename$")
	public void user_Moves_to_Releasename() throws Throwable 
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

	@When("^User Creates Phase in release$")
	public void user_Creates_Phase_in_release() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
			String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			actual[4]=tr.addNode(Name, Desc);
		    bp.waitForElement();
		    tr.doubleClickOnRelease(releaseName);
		    String navigation[]=new String[1];
		    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
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

	@When("^User Adds Testcase to Phase$")
	public void user_Adds_Testcase_to_Phase() throws Throwable 
	{
	    try
	    {
	    	actual[6]=tr.addTestCase();
	    	bp.waitForElement();
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

	@When("^User Adds Teststeps to the Testcase$")
	public void user_Adds_Teststeps_to_the_Testcase() throws Throwable 
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
			e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Perform DragAndDrop Operation$")
	public void user_Perform_DragAndDrop_Operation() throws Throwable 
	{
	   try
	   {
		   ctc=new CreateTestCasePage(driver);
		   actual[9]= ctc.dnDForTestStepsDetails(2, 1);
		    bp.waitForElement();
		    actual[10]=ctc.dnDForTestStepsDetails(1, 2);
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

	@Then("^Testcases should be Reorderd successfully$")
	public void testcases_should_be_Reorderd_successfully() throws Throwable 
	{
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
	        {
	         soft.assertEquals(actual[k], true);
	        }
	        soft.assertAll();
	        log.info("Pass - Testcases should be Reorderd successfully");
	        
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
