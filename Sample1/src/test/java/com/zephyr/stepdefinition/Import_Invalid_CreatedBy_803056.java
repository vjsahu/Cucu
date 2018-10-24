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

public class Import_Invalid_CreatedBy_803056 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_Invalid_CreatedBy_803056";
	boolean[] actual=new boolean[10];
	  SoftAssert soft=new SoftAssert();
	  

@Given("^User is Present in the TestRepository(\\d+)$")
public void user_is_Present_in_the_TestRepository(int arg1) throws Throwable {
	try
	{
//	lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
		if(arg1==1)
		{
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]= rp.clickOnTestRep(); 
		}
		
		
		if(arg1==2)
    {
	pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",2,0);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]= rp.clickOnTestRep(); 
	}
	
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

//	@Given("^User is Present in the TestRepository$")
//	public void user_is_Present_in_the_TestRepository() throws Throwable 
//	{
//		try
//		{
////		lb=new LaunchBrowser();
////		   lb.preCond();
////		   lp=new LoginPage(driver);
////		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
////		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
////		   lp.enterUname(Uname);
////		   lp.enterPass(Pass);
////		   lp.clickOnLogin();
//		   
//		   pp=new ProjectPage(driver);
//		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
//		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
//		   actual[0]=pp.selectProject(projectName);
//		   actual[1]=pp.selectRelease(releaseName);
//		   
//		   rp= new ReleasePage(driver);
//		   actual[2]= rp.clickOnTestRep(); 
//		}
//		catch(Exception e)
//		{
//			lb=new LaunchBrowser();
//			lb.getScreenShot(fileName);	
//			driver.close();
//			Relogin rl=new Relogin();
//			rl.reLogin();
//			throw e;
//		}
//	}

@When("^User Navigates to the REleaseName(\\d+)$")
public void user_Navigates_to_the_REleaseName(int arg1) throws Throwable {
	try
	{
		if(arg1==1)
		{
	tr=new TestRepositoryPage(driver);
	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	 actual[3]=tr.doubleClickOnRelease(releaseName);
		}
		
		if(arg1==2)
		{
	tr=new TestRepositoryPage(driver);
	 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",2,0);
	 actual[3]=tr.doubleClickOnRelease(releaseName);
		}
		
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
	

	@When("^User clicks on Import$")
	public void user_clicks_on_Import() throws Throwable 
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

	@When("^User Creates Map with Email in Created By Field$")
	public void user_Creates_Map_with_Email_in_Created_By_Field() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 14, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
		String[] ZephyrFields= new String[17];
		ZephyrFields[0]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
		ZephyrFields[1]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 0);
		ZephyrFields[2]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 1);
		ZephyrFields[3]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 2);
		ZephyrFields[4]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 3);
		ZephyrFields[5]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 4);
		ZephyrFields[6]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 5);
		ZephyrFields[7]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 6);
		ZephyrFields[8]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 7);
		ZephyrFields[9]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 8);
		ZephyrFields[10]=Excel_Lib.getData(INPUT_PATH, "Create_Map",8, 9);
		ZephyrFields[11]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 10);
		ZephyrFields[12]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 11);
		ZephyrFields[13]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 12);
		ZephyrFields[14]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 13);
		ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 10);
		ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 14);
		actual[5]= ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
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

	@When("^User Imports File and Runs the Import Job$")
	public void user_Imports_File_and_Runs_the_Import_Job() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 6, 0);
		String mapName=Excel_Lib.getData(INPUT_PATH, "Create_Map", 14, 0);
	   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 6, 2);
	   actual[6]= ip.importTestCase(jobname, mapName, path);
	   bp.waitForElement();
	   actual[7]= ip.runJob();
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
	
	

@Then("^Import Job should be Run Successfully(\\d+)$")
public void import_Job_should_be_Run_Successfully(int arg1) throws Throwable {

	try
	{
		actual[8]=ip.ClickOKonStatusReport();
		if(arg1==1)
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",3,3);
			
			actual[9]= ip.validateImport(fileName, releaseName);
		}
		else 
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",2,0);
			String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",3,3);
			
			actual[9]= ip.validateImport(fileName, releaseName);
		}
	
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


//	@Then("^Import Job should be Run Successfully$")
//	public void import_Job_should_be_Run_Successfully() throws Throwable 
//	{
//		try
//		{
//			actual[8]=ip.ClickOKonStatusReport();
//		String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",3,3);
//		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
//		actual[9]= ip.validateImport(fileName, releaseName);
//		for(int k=0;k<=actual.length-1;k++)
//	       {
//	        soft.assertEquals(actual[k], true);
//	       }
//	       soft.assertAll();
//	    log.info("Pass - File with Automated field is Imported Successfully");
//		}
//		catch(Exception e)
//		{
//			lb=new LaunchBrowser();
//			lb.getScreenShot(fileName);	
//			driver.close();
//			Relogin rl=new Relogin();
//			rl.reLogin();
//			throw e;
//		}
//	}
}

