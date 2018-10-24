package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Import_MissMatch_803011 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	BasePage bp;
	String fileName="Import_MissMatch_803011";
	boolean[] actual=new boolean[7];
	  SoftAssert soft=new SoftAssert();
	
	@Given("^User is Moved to the TestRepository$")
	public void user_is_Moved_to_the_TestRepository() throws Throwable
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
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User navigates to the ReleaseName$")
	public void user_navigates_to_the_ReleaseName() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User clicks on the Import$")
	public void user_clicks_on_the_Import() throws Throwable 
	{
		try
		{
		ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[4]=ip.clickOnImport();
		   bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Imports the TestCases with Miss-Match Values$")
	public void user_Imports_the_TestCases_with_Miss_Match_Values() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 2, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 7);
		ImportPage ip= new ImportPage(driver);
		actual[5]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	    bp.waitForElement();
	    
	    String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 4, 0);
		String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 4, 1);
		String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 4, 2);
		actual[6]=ip.importTestCase(jobname, mapName, path);
		bp.waitForElement();
	    ip.closeInstruction.click();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	}
	catch(Exception e)
	{
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		driver.close();
		Relogin rl=new Relogin();
		rl.reLogin();
		throw e;
	}

	}

	@Then("^Import should be successfull with Miss-Match values$")
	public void import_should_be_successfull_with_Miss_Match_values() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	    log.info("Pass - Import should be successfull with Miss-Match values");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
}
