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

public class Import_NestedFolder_803083 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_NestedFolder_803083";
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	@Given("^User present in the Testrepository$")
	public void user_present_in_the_Testrepository() throws Throwable 
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
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep();  
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

	@When("^User clicks on releasename$")
	public void user_clicks_on_releasename() throws Throwable 
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

	@When("^user clicks on import icon$")
	public void user_clicks_on_import_icon() throws Throwable 
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

	@When("^user creates a map$")
	public void user_creates_a_map() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		
		
		
	
			String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
			String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
			String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
			String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
			String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
			String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
			String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
			ImportPage ip= new ImportPage(driver);
			actual[5]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
		
		
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

	@When("^user Imports a file with nested directory$")
	public void user_Imports_a_file_with_nested_directory() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 0);
		   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 1);
		   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 8, 2);
		   actual[6]= ip.importTestCase(jobname, mapName, path);
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

	@When("^user Runs the Import Job$")
	public void user_Runs_the_Import_Job() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		actual[7]=ip.runJob();
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

	@Then("^File should be Imported Successfully to the Imported folder$")
	public void file_should_be_Imported_Successfully_to_the_Imported_folder() throws Throwable 
	{
		try
		{
			ip.ClickOKonStatusReport();
		String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",8,3);
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
