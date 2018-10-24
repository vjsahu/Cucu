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

public class Import_CreateImportedPhase_ImportTc_803020 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_CreateImportedPhase_ImportTc_803020";
	boolean[] actual=new boolean[11];
	  SoftAssert soft=new SoftAssert();
	
	@Given("^User moved to the TestRepository$")
	public void user_moved_to_the_TestRepository() throws Throwable 
	{
		try
		{
//		   lb=new LaunchBrowser();
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

	@When("^User moes to the Release$")
	public void user_moes_to_the_Release() throws Throwable 
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

	@When("^User Creates a phase with name 'Imported'$")
	public void user_Creates_a_phase_with_name_Imported() throws Throwable
	{
		try
		{
		bp=new BasePage();
		String Name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 8);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 9);
		actual[4]=tr.addNode(Name, Desc);
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

	@When("^User Imports a Testcase$")
	public void user_Imports_a_Testcase() throws Throwable 
	{
		try
		{
		    ip= new ImportPage(driver);
		    bp=new BasePage();
		    bp.waitForElement();
		    actual[5]=ip.clickOnImport();
		    bp.waitForElement();
		    
			String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
			String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
			String name=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
			String testSteps=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
			String expResults=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
			String extrID=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
			ImportPage ip= new ImportPage(driver);
			actual[6]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
		    bp.waitForElement();
		    
		   bp.waitForElement();
		   String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 0);
		   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 1);
		   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 2);
		   actual[7]=ip.importTestCase(jobname, mapName, path);
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

	@Then("^Testcase should be successfully added to the 'Imported' folder not in Phase$")
	public void testcase_should_be_successfully_added_to_the_Imported_folder_not_in_Phase() throws Throwable 
	{
		try
		{
		    bp=new BasePage();
		    actual[8]=ip.runJob();
		    bp.waitForElement();
		    actual[9]=ip.ClickOKonStatusReport();
		    bp.waitForElement();
			String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",1,3);
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			actual[10]=ip.validateImport(fileName, releaseName);
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
