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

public class Import_Filename_SpeclChar_803087 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_Filename_SpeclChar_803087";
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	@Given("^User is in the Testrepository Module$")
	public void user_is_in_the_Testrepository_Module() throws Throwable 
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
		  actual[0]= pp.selectProject(projectName);
		  actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();  
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

	@When("^User Clicks on Releasename$")
	public void user_Clicks_on_Releasename() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[2]=tr.doubleClickOnRelease(releaseName);
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

	@When("^User Clicks on ImporTIcon$")
	public void user_Clicks_on_ImporTIcon() throws Throwable 
	{
		try
		{
		ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[3]=ip.clickOnImport();
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

	@When("^User creates map$")
	public void user_creates_map() throws Throwable 
	{
		try
		{
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 5, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 2);
		String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 3);
		String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 5, 7);
		ImportPage ip= new ImportPage(driver);
		actual[4]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
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

	@When("^User Imports file with Special Characters and Runs it$")
	public void user_Imports_file_with_Special_Characters_and_Runs_it() throws Throwable 
	{
		try
		{
		String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 7, 0);
		   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 7, 1);
		   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 7, 2);
		   actual[5]=ip.importTestCase(jobname, mapName, path);
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

	@Then("^The filename with special characters should be Imported successfully$")
	public void the_filename_with_special_characters_should_be_Imported_successfully() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		actual[6]=ip.runJob();
		bp.waitForElement();
		actual[7]=ip.ClickOKonStatusReport();
		String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",7,3);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[8]=ip.validateImport(fileName, releaseName);
		for(int k=0;k<=actual.length-1;k++)
	       {
	        soft.assertEquals(actual[k], true);
	       }
	       soft.assertAll();
	    log.info("Pass - File with Automated field is Imported Successfully");
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
