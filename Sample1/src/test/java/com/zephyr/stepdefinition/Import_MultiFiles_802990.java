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

public class Import_MultiFiles_802990 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	BasePage bp;
	boolean[] actual=new boolean[6];
	  SoftAssert soft=new SoftAssert();
	  
	  String fileName="Import_MultiFiles_802990";
	  LaunchBrowser lb=new LaunchBrowser();
	@Given("^User moves upto TestRepository$")
	public void user_moves_upto_TestRepository() throws Throwable 
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

	@When("^User moves to Release$")
	public void user_moves_to_Release() throws Throwable
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[2]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Clicks on Import$")
	public void user_Clicks_on_Import() throws Throwable 
	{
		try
		{
		 ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[3]=ip.clickOnImport();
		   bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Import the Multiple Testcases by Directory path$")
	public void user_Import_the_Multiple_Testcases_by_Directory_path() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
		ImportPage ip= new ImportPage(driver);
		actual[4]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	    bp.waitForElement();
	    
	   bp.waitForElement();
	   String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 0);
	   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 1);
	   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 2);
	   actual[5]=ip.importTestCase(jobname, mapName, path);
	   bp.waitForElement();
	    ip.closeInstruction.click();
	    bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Multiple Testcases are Imported Successfully$")
	public void multiple_Testcases_are_Imported_Successfully() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	       {
	        soft.assertEquals(actual[k], true);
	       }
	       soft.assertAll();
	    log.info("Pass - Multiple Testcases are Imported Successfully");
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
	
}
