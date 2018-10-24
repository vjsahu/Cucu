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

public class Add_TC_WithAllCustomFields_808895 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	NavigationPage np;
	ExportPage ep;
	
	String fileName="Add_TC_WithAllCustomFields_808895";
	
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User Navigated to the TestRepositoryPage$")
	public void user_Navigated_to_the_TestRepositoryPage() throws Throwable 
	{
	    try
	    {
//		
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
	    	lb=new LaunchBrowser();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   actual[0]= pp.selectProject(projectName);
			   actual[1]= pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   actual[2]= rp.clickOnTestRep();
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

	@When("^User Creates a Phase and Navigates to created Phase$")
	public void user_Creates_a_Phase_and_Navigates_to_created_Phase() throws Throwable 
	{
	    try
	    {
	    	bp=new BasePage();
			tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			 actual[3]= tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     bp=new BasePage();
		     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		     actual[4]= tr.addNode(Name, Desc);
		     bp.waitForElement();
		     actual[5]= tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     String navigation[]=new String[1];
		     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     actual[6]= tr.navigateToNode(releaseName, navigation);
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

	@When("^User Adds Testcase$")
	public void user_Adds_Testcase() throws Throwable 
	{
	    try
	    {
	    	actual[7]=tr.addTestCase();
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

	@When("^User Clicks on Detail View$")
	public void user_Clicks_on_Detail_View() throws Throwable 
	{
	    try
	    {
	    	actual[8]=tr.clickOnDetails();
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

	@When("^User Enters Name and Description for Testcase$")
	public void user_Enters_Name_and_Description_for_Testcase() throws Throwable 
	{
	    try
	    {
	    	ctc=new CreateTestCasePage(driver);
	    	String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,2);
			String testCaseDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Modify_TC",3,3);
			actual[9]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
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

	@When("^User Enters all Custom Fields ans Saves it$")
	public void user_Enters_all_Custom_Fields_ans_Saves_it() throws Throwable 
	{
	    try
	    {
	    	ctc.clickOnCustomField.click();
	    	bp.waitForElement();
	    	String text=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 9);
	    	String longText=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 10);
	    	String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 11));
	    	String checkBox=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 12);
	    	String pickupList=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 13);
	    	String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 14));
	    	ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
	    	bp.waitForElement();
	    	ctc.clickOnCustomField.click();
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

	@Then("^Testcase Should be created with all Custom Fields$")
	public void testcase_Should_be_created_with_all_Custom_Fields() throws Throwable 
	{
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		    {
		    	System.out.println(actual[k]);
		    	soft.assertEquals(actual[k], true);
		    }
			soft.assertAll();
	    	log.info("Pass - Testcase Should be created with all Custom Fields");
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
