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

public class Edit_Multiselected_TcDetails_809222 extends LaunchBrowser
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
	String fileName="Edit_Multiselected_TcDetails_809222";
	
	@Given("^User Present in the TestRepository$")
	public void user_Present_in_the_TestRepository() throws Throwable 
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

	@When("^User Clicks On Release$")
	public void user_Clicks_On_Release() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     tr.doubleClickOnRelease(releaseName);
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

	@When("^User Creates Phase and Selects it$")
	public void user_Creates_Phase_and_Selects_it() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
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
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Creates a Testcase with all Fields$")
	public void user_Creates_a_Testcase_with_all_Fields() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		tr.addTestCase();
		bp.waitForElement();
		tr.addTestCase();
		bp.waitForElement();
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

	@When("^User navigate back to Release and Phase$")
	public void user_navigate_back_to_Release_and_Phase() throws Throwable 
	{
	    try
	    {
	    	ep=new ExportPage(driver);
	    	String testCaseNo[]=new String[2];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 6, 1));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0));
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

	@When("^User selects the Created Testcase$")
	public void user_selects_the_Created_Testcase() throws Throwable 
	{
	    try
	    {
	    	ctc=new CreateTestCasePage(driver);
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

	@When("^User Changes the Fields in Testcase and Saves it$")
	public void user_Changes_the_Fields_in_Testcase_and_Saves_it() throws Throwable 
	{
	    try
	    {
	    	ctc=new CreateTestCasePage(driver);
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
	    	System.out.println(checkBox);
	    	ctc.editCustomFieldsInMultipleTestCase(text, longText, number, checkBox, pickupList, date);
	    	bp.waitForElement();
	    	ctc.saveMultipleTestCaseEdit();
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

	@Then("^Changes should be successfully applied for the Testcases$")
	public void changes_should_be_successfully_applied_for_the_Testcases() throws Throwable 
	{
	    try
	    {
	    	//ctc.saveMultipleTestCaseEdit();
	    	log.info("Pass - Changes should be successfully applied for the Testcases");
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
