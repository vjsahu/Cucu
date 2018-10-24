package com.zephyr.stepdefinition;

import org.openqa.selenium.interactions.Actions;

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

public class Rename_FileIn_ImportedFolder_803025 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Rename_FileIn_ImportedFolder_803025";
	
	@Given("^User is in Testrepository page$")
	public void user_is_in_Testrepository_page() throws Throwable 
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

	@When("^User navigates to Releasename$")
	public void user_navigates_to_Releasename() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	     tr.doubleClickOnRelease(releaseName);
	     bp.waitForElement();
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

	@When("^User Clicks on Imported Folder$")
	public void user_Clicks_on_Imported_Folder() throws Throwable 
	{
		try
		{
		 ip= new ImportPage(driver);
		 bp=new BasePage();
		 ip.clickOnImport();
		   bp.waitForElement();
		
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
			ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
		    bp.waitForElement();
		    
		   bp.waitForElement();
		   String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 2, 0);
		   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 2, 1);
		   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 2, 2);
		   ip.importTestCase(jobname, mapName, path);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		     ip.runJob();
			 bp.waitForElement();
			ip.ClickOKonStatusReport();
		    bp.waitForElement();
			
			String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",2,3);
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			ip.validateImport(fileName, releaseName);
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
			
//		ip=new ImportPage(driver);
//		Actions act=new Actions(driver);
//		act.doubleClick(ip.Imported).perform();
	}

	@When("^User Rename the Selected file$")
	public void user_Rename_the_Selected_file() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String fileName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 2, 3);
	    ip.selectImportFile1(fileName);
	    bp.waitForElement();
	    String rename=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Import_Job", 2, 3);
	    ip.renameImportedFile(rename);
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

	@Then("^File should be Renamed Successfully$")
	public void file_should_be_Renamed_Successfully() throws Throwable 
	{
		try
		{
	    log.info("File should be Renamed Successfully");
	    
	    //String imported=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 4);
	    
	   
	    Actions act=new Actions(driver);
	    act.doubleClick(ip.Imported).perform();
	    bp.waitForElement();
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
}
