package com.zephyr.stepdefinition;

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

public class Modify_ImportJob_803005 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Modify_ImportJob_803005";
	
	@Given("^User Is Present in the TestRepositoryPage$")
	public void user_Is_Present_in_the_TestRepositoryPage() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LUname");
//		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LPass");
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		try
		{
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

	@When("^Use navigates to Release$")
	public void use_navigates_to_Release() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     tr.doubleClickOnRelease(releaseName);
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

	@When("^User clicks on importicon$")
	public void user_clicks_on_importicon() throws Throwable 
	{
		try
		{
		ip= new ImportPage(driver);
		 bp=new BasePage();
		 ip.clickOnImport();
	
		  bp.waitForElement();
		  String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
			String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
			String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
			String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
			String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
			String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
			ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
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

	@When("^User Moves to the ImportJob Field$")
	public void user_Moves_to_the_ImportJob_Field() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		ip=new ImportPage(driver);
		
		//ip.nextForImport.click();
		bp.waitForElement();

		//ip.selectImportJob.click();
		//bp.waitForElement();
		//bp.eraseText(ip.selectImportJob);
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

	@When("^User Selects a Job and Modifies it$")
	public void user_Selects_a_Job_and_Modifies_it() throws Throwable 
	{
		try
		{
	   String jobname=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 7, 0);
	   String mapName=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 7, 1);
	   String path=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 7, 2);
	   ip.importTestCase(jobname, mapName, path);
	   ip.runJob();
	   bp.waitForElement();
	   ip.ClickOKonStatusReport();
	   bp.waitForElement();
	   ip.closeInstruction.click();
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

	@Then("^Importjob should be modified successfully$")
	public void importjob_should_be_modified_successfully() throws Throwable 
	{
		try
		{
	    log.info("Pass - Importjob should be modified successfully");
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
