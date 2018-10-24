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

public class Import_TC_As_CUser_809384 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	String fileName="Import_TC_As_CUser_809384";
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^User is in TestRepo page$")
	  public void user_is_in_TestRepo_page() throws Throwable 
	  {
		  try
		  {
		  //	lb=new LaunchBrowser();
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
	  
	  @When("^User Clicks on Import Testcase Icon$")
	  public void user_Clicks_on_Import_Testcase_Icon() throws Throwable 
	  {
	      try
	      {
	    	  tr=new TestRepositoryPage(driver);
	 		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	 		 actual[3]=tr.doubleClickOnRelease(releaseName);
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

	  @When("^User Creates Map with Matching field$")
	  public void user_Creates_Map_with_Matching_field() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	  		String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
	  		int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
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
	  		ZephyrFields[10]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 9);
	  		ZephyrFields[11]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 10);
	  		ZephyrFields[12]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 11);
	  		ZephyrFields[13]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 12);
	  		ZephyrFields[14]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 13);
	  		ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 10);
	  		ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 14);
	  		String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
	  		actual[5]=ip.updateMap(mapname, rownum,descrimi ,ZephyrFields);
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

	  @When("^User Creates the ImportJob$")
	  public void user_Creates_the_ImportJob() throws Throwable 
	  {
	      try
	      {
	    	  bp=new BasePage();
	  		String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 0);
	  	   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 1);
	  	   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 3, 2);
	  	   actual[6]=ip.importTestCase(jobname, mapName, path);
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

	  @When("^User Runs the ImportedJob$")
	  public void user_Runs_the_ImportedJob() throws Throwable 
	  {
	      try
	      {
	    	  actual[7]=ip.runJob();
		  	   bp.waitForElement();
		  	 ip.ClickOKonStatusReport();
				
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

	  @Then("^File should be Imported Successfully to the Imported Folder$")
	  public void file_should_be_Imported_Successfully_to_the_Imported_Folder() throws Throwable 
	  {
	      try
	      {
	    	  String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",3,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				actual[8]=ip.validateImport(fileName, releaseName);
				
				for(int k=0;k<=actual.length-1;k++)
			       {
			        soft.assertEquals(actual[k], true);
			       }
			       soft.assertAll();
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
