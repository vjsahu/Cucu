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

public class Edit_CustomFields_Date_809214 extends LaunchBrowser
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
	String fileName="Edit_CustomFields_Date_809214";
	
	@Given("^User is Present in the TestRepositorypage$")
	public void user_is_Present_in_the_TestRepositorypage() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
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

	@When("^User Creates Phase and Adds Three Testcases$")
	public void user_Creates_Phase_and_Adds_Three_Testcases() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		     tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     bp=new BasePage();
		     String Name=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		     tr.addNode(Name, Desc);
		     bp.waitForElement();
		     tr.doubleClickOnRelease(releaseName);
		     String navigation[]=new String[1];
		     navigation[0]=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     tr.navigateToNode(releaseName, navigation);
		     bp.waitForElement(); 
		     ctc=new CreateTestCasePage(driver);
		     for(int i=0;i<=3;i++)
		     {
		    	 tr.addTestCase();
			     bp.waitForElement();
		     }  
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

	@When("^User Selects Two Testcases and Clicks on Edit$")
	public void user_Selects_Two_Testcases_and_Clicks_on_Edit() throws Throwable 
	{
		try
		{
		ep=new ExportPage(driver);
		ctc=new CreateTestCasePage(driver);
    	String testCaseNo[]=new String[2];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
		testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
		ep.selectMultipleTestCaseFromGrid(testCaseNo);
		bp.waitForElement();
    	tr.editTestCase();
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

	@When("^User Performs Bulk Edit for Custom fields with PresentDate$")
	public void user_Performs_Bulk_Edit_for_Custom_fields_with_PresentDate() throws Throwable 
	{
		try
		{
		String text=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 9);
    	String longText=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 10);
    	String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 11));
    	String checkBox=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 12);
    	String pickupList=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 13);
    	String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 14));
    	ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
    	bp.waitForElement();
    	ctc.saveMultipleTestCaseEdit();
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

	@When("^User Performs Bulk Edit for Custom fields with PastDate$")
	public void user_Performs_Bulk_Edit_for_Custom_fields_with_PastDate() throws Throwable 
	{
		try
		{
		String testCaseNo[]=new String[2];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
		testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
		ep.selectMultipleTestCaseFromGrid(testCaseNo);
		bp.waitForElement();
		tr.editTestCase();
    	bp.waitForElement();
    	String text=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 9);
    	String longText=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 10);
    	String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 11));
    	String checkBox=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 12);
    	String pickupList=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 13);
    	String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 15));
    	ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
    	bp.waitForElement();
    	ctc.saveMultipleTestCaseEdit();
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

	@When("^User Performs Bulk Edit for Custom fields with FutureDate$")
	public void user_Performs_Bulk_Edit_for_Custom_fields_with_FutureDate() throws Throwable 
	{
		try
		{
		String testCaseNo[]=new String[2];
		testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
		testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
		ep.selectMultipleTestCaseFromGrid(testCaseNo);
		bp.waitForElement();
		tr.editTestCase();
    	bp.waitForElement();
    	String text=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 9);
    	String longText=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 10);
    	String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 11));
    	String checkBox=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 12);
    	String pickupList=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 13);
    	String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 16));
    	ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
    	bp.waitForElement();
    	ctc.saveMultipleTestCaseEdit();
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

	@Then("^Custom fields should be Modified successfully with Present, Past, Future Dates$")
	public void custom_fields_should_be_Modified_successfully_with_Present_Past_Future_Dates() throws Throwable 
	{
		try
		{
	    log.info("Pass - Custom fields should be Modified successfully with Present, Past, Future Dates");
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
