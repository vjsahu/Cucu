package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Edit_Import_Delete_803046 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_Import_Delete_803046";
	
	boolean[] actual=new boolean[17];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User in The Repository page$")
	public void user_in_The_Repository_page() throws Throwable 
	{

		try
		{
			bp=new BasePage();
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin rl=new Relogin();
		      	rl.reLogin();
		      	throw e;
		}
	}

	@When("^The import is sucessful$")
	public void the_import_is_sucessful() throws Throwable
	{
		try
		{
		
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
	     bp.waitForElement();
	     
	     ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[4]=ip.clickOnImport();
		  bp.waitForElement();
		  
		  bp=new BasePage();
			String mapname=Excel_Lib.getData(INPUT_PATH_4, "Import_Job1", 9, 1);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "Create_Map1", 1, 1);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 3);
			String name=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 4);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 5);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 6);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "Create_Map1", 1, 7);
			ImportPage ip= new ImportPage(driver);
			actual[5]=ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
		    bp.waitForElement();
		    
		   bp.waitForElement();
		   String jobname=Excel_Lib.getData(INPUT_PATH_4, "Import_Job1", 9, 0);
		   String mapName=Excel_Lib.getData(INPUT_PATH_4, "Import_Job1", 10, 1);
		   String path=Excel_Lib.getData(INPUT_PATH_4, "Import_Job1", 9, 2);
		   actual[6]=ip.importTestCase(jobname, mapName, path);
		   
		   
		   ip.runJob();
		   
		   ip.ClickOKonStatusReport();
			String fileName=Excel_Lib.getData(INPUT_PATH_4,"Import_Job1",9,3);
			String releaseName1=Excel_Lib.getData(INPUT_PATH_4,"Releases",1,0);
			actual[7]=ip.validateImport(fileName, releaseName1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		  
	}

	@When("^copy the imported node$")
	public void copy_the_imported_node() throws Throwable 
	{
		try
		{
			
		
		String fileName=Excel_Lib.getData(INPUT_PATH_4,"Import_Job1",9,3);
		actual[8]=ip.selectImportFile1(fileName);
		actual[9]=tr.copyNode();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		  
	}

	@When("^Paste the node in the phase$")
	public void paste_the_node_in_the_phase() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases",1,0);
		 actual[10]=tr.doubleClickOnRelease(releaseName);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails",5,0);
		String desc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails",5,0);
		actual[11]=tr.addNode(name, desc);
		bp.waitForElement();
		actual[12]=tr.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=name;
		actual[13]=tr.navigateToNode(releaseName, phase);
		
		actual[14]=tr.pasteNode();
		
		bp.waitForElement();
		}
	    //tr.pasteNode();
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		  
	}

	@When("^Delete the imported file$")
	public void delete_the_imported_file() throws Throwable 
	{
		
		try
		{
			tr=new TestRepositoryPage(driver);
		
		  ip= new ImportPage(driver);
			 bp=new BasePage();
			 
			 
		String fileName=Excel_Lib.getData(INPUT_PATH_4,"Import_Job1",9,3);
		actual[15]=ip.selectImportFile1(fileName);
	    bp.waitForElement();
		
		actual[16]=tr.deleteNode();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		  
	}

	@Then("^should remains in phase$")
	public void should_remains_in_phase() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
        {
         soft.assertEquals(actual[k], true);
        }
        soft.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
		  
	}
}
