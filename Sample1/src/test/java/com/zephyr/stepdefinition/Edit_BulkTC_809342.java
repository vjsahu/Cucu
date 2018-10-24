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

public class Edit_BulkTC_809342 extends LaunchBrowser
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
	
	String fileName="Edit_BulkTC_809342";
	
	@Given("^User is present in the TestRepositorypage$")
	public void user_is_present_in_the_TestRepositorypage() throws Throwable 
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
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Creates phase and adds Five Testcases$")
	public void user_Creates_phase_and_adds_Five_Testcases() throws Throwable 
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
		     ctc=new CreateTestCasePage(driver);
		     for(int i=0;i<=5;i++)
		     {
		    	 tr.addTestCase();
			     bp.waitForElement();
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

	@When("^User selects Three Testcases and Performs Edit Operation in Bulk$")
	public void user_selects_Three_Testcases_and_Performs_Edit_Operation_in_Bulk() throws Throwable 
	{
		try
		{
			ep=new ExportPage(driver);
			ctc=new CreateTestCasePage(driver);
	    	String testCaseNo[]=new String[3];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
			testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 4, 0));
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
	    	
	    	String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 6));
	    	String hour=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 7));
	    	String min=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 8));
	    	ctc.editEstimatedTimeInMultiTc(day, hour, min);
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
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	    
	}

	@When("^User adds Three more testcases in same phase$")
	public void user_adds_Three_more_testcases_in_same_phase() throws Throwable 
	{
		try
		{
			bp.waitForElement(); 
		     ctc=new CreateTestCasePage(driver);
		     for(int i=0;i<=3;i++)
		     {
		    	 tr.addTestCase();
			     bp.waitForElement();
		     }  
		     String testCaseNo[]=new String[3];
		     testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
		     testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
		     testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 4, 0));
		     ep.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User Performs Bulk Edit operation without Custom fields$")
	public void user_Performs_Bulk_Edit_operation_without_Custom_fields() throws Throwable 
	{
		try
		{
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
	    	
	    	String day=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 6));
	    	String hour=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 7));
	    	String min=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 8, 8));
	    	ctc.editEstimatedTimeInMultiTc(day, hour, min);
	    	//ctc.saveMultipleTestCaseEdit();
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

	@Then("^Bulk edited testcases without custom fields should retain Same values$")
	public void bulk_edited_testcases_without_custom_fields_should_retain_Same_values() throws Throwable 
	{
		try
		{
			ctc.saveMultipleTestCaseEdit();
			log.info("Pass - Bulk edited testcases without custom fields should retain Same values");
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
