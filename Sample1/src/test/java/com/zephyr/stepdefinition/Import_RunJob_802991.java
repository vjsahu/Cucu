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

public class Import_RunJob_802991 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_RunJob_802991";
	boolean[] actual=new boolean[10];
	  SoftAssert soft=new SoftAssert();
	@Given("^User is present in TestRepositoryPage$")
	public void user_is_present_in_TestRepositoryPage() throws Throwable 
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
//		   
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

	@When("^User Navigates to the Releasename$")
	public void user_Navigates_to_the_Releasename() throws Throwable
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
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

	@When("^User Clicks on Importbutton$")
	public void user_Clicks_on_Importbutton() throws Throwable 
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

	

@When("^User Moves to ImprtJob Page \"([^\"]*)\"$")
public void user_Moves_to_ImprtJob_Page(String descrimi) throws Throwable {
	try
	{
	bp=new BasePage();
	String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
	int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
    if(descrimi.equals("Id"))
    {
	descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
    }
    else if(descrimi.equals("empty row"))
    {
    	descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
    }
    else
    {
    	descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 3, 2);
    }
	String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
	String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
	String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
	String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
	String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
	ImportPage ip= new ImportPage(driver);
	actual[5]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
    bp.waitForElement();
    
   bp.waitForElement();
   String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 0);
   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 1);
   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 2);
   actual[6]=ip.importTestCase(jobname, mapName, path);
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
	
	

	@When("^User Runs the Import Job$")
	public void user_Runs_the_Import_Job() throws Throwable 
	{
		try
		{
			actual[7]=ip.runJob();
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

	@Then("^Import Job should Run Successfully$")
	public void import_Job_should_Run_Successfully() throws Throwable 
	{
		try
		{
			actual[8]=ip.ClickOKonStatusReport();
		String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",1,3);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[9]=ip.validateImport(fileName, releaseName);
		for(int k=0;k<=actual.length-1;k++)
	       {
	        soft.assertEquals(actual[k], true);
	       }
	       soft.assertAll();
	    log.info("Pass - Import Job Run Successfully");
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
