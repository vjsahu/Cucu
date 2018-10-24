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

public class Edit_Bulk_AutomatedScriptField_809265 extends LaunchBrowser
{
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	NavigationPage np;
	ExportPage ep;
	
	String fileName="Edit_Bulk_AutomatedScriptField_809265";
	
	@Given("^User Present in the TestRepositoryPage$")
	public void user_Present_in_the_TestRepositoryPage() throws Throwable 
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
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Creates phase$")
	public void user_Creates_phase() throws Throwable 
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
		     bp.waitForElement();
		     tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     String navigation[]=new String[1];
		     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		     tr.navigateToNode(releaseName, navigation);
		     bp.waitForElement(); 
	    }
	    catch(Exception e)
		{  lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Adds Three Testcase with AutomatedScript Field to the Phase$")
	public void user_Adds_Three_Testcase_with_AutomatedScript_Field_to_the_Phase() throws Throwable 
	{
	    try
	    {
	    	ctc=new CreateTestCasePage(driver);
		     for(int i=0;i<=3;i++)
		     {
		    	 tr.addTestCase();
			     bp.waitForElement();
		     } 
		     tr=new TestRepositoryPage(driver);
		     ep=new ExportPage(driver);
		     ctc=new CreateTestCasePage(driver);
		     String testCaseNo[]=new String[2];
		     testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
		     testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
		     ep.selectMultipleTestCaseFromGrid(testCaseNo);
		     bp.waitForElement();
		     
		     tr.editTestCase();
		     bp.waitForElement();
		    	
		     String detailField[]=new String[3];
		     detailField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 0);
		     detailField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 1);
		     detailField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 2);
		     String automationField[]=new String[4];
		     automationField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 3);
		     automationField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 4);
		     automationField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 5);
		     automationField[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 7, 2);
		     ctc.editMultipleTestCase(detailField, automationField);
		     bp.waitForElement();
		     ctc.saveMultipleTestCaseEdit();
		     bp.waitForElement();
	    }
	    catch(Exception e)
		{ lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Selects Two Testcases for Bulk Edit Operation$")
	public void user_Selects_Two_Testcases_for_Bulk_Edit_Operation() throws Throwable
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

	@When("^User Edits AutomatedScript with only some fields$")
	public void user_Edits_AutomatedScript_with_only_some_fields() throws Throwable 
	{
	    try
	    {
	    	String detailField[]=new String[3];
		     detailField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 0);
		     detailField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 1);
		     detailField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 2);
		     String automationField[]=new String[4];
		     automationField[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 3);
		     automationField[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 4);
		     automationField[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 8, 5);
		     automationField[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 100, 100);
		     ctc.editMultipleTestCase(detailField, automationField);
		     bp.waitForElement();
		     ctc.saveMultipleTestCaseEdit();
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

	@Then("^AutomatedScript with only some fields should be Modified successfully$")
	public void automatedscript_with_only_some_fields_should_be_Modified_successfully() throws Throwable 
	{
	    try
	    {
	    	log.info("Pass - AutomatedScript with only some fields should be Modified successfully");
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
