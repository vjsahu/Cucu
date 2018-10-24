package com.zephyr.stepdefinition;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Import_ByChanging_CheckBoxValue_AfterExport_809424 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ImportPage ip;
	String fileName="Import_ByChanging_CheckBoxValue_AfterExport_809424";
	boolean[] actual=new boolean[12];
	  SoftAssert soft=new SoftAssert();
	  
	  @Given("^User is present in the Testrepositorypage$")
	  public void user_is_present_in_the_Testrepositorypage() throws Throwable 
	  {
	      try
	      {
//	  		lb=new LaunchBrowser();
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
	    	  ctc=new CreateTestCasePage(driver);
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
	    	  e.printStackTrace();
	    	  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	  }

	  @When("^User Clicks on Import Icon$")
	  public void user_Clicks_on_Import_Icon() throws Throwable 
	  {
		  try
		  {
			  ip= new ImportPage(driver);
				 bp=new BasePage();
				 tr=new TestRepositoryPage(driver);
				 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				 actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				 actual[4]=ip.clickOnImport();
				  bp.waitForElement();
		  }
		  catch(Exception e)
			{
			  lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			  e.printStackTrace();
			  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	      
	  }

	  @When("^User Creates map with matching checkbox field$")
	  public void user_Creates_map_with_matching_checkbox_field() throws Throwable 
	  {
		  try
		  {
			  bp=new BasePage();
				String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 0);
				int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 9, 1);
				String[] ZephyrFields= new String[23];
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
				ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 99);
				ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 18);
				ZephyrFields[17]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 19);
				ZephyrFields[18]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 20);
				ZephyrFields[19]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 21);
				ZephyrFields[20]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 22);
				ZephyrFields[21]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 23);
				ZephyrFields[22]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 24);
				String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
				actual[5]=ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
		  }
		  catch(Exception e)
			{
			  lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			  e.printStackTrace();
			  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	      
	  }

	  @When("^User perform Import Job by selecting Created Map$")
	  public void user_perform_Import_Job_by_selecting_Created_Map() throws Throwable 
	  {
		  try
		  {
			  String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 0);
			   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 1);
			   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 2);
			   actual[6]=ip.importTestCase(jobname, mapName, path);
			   bp.waitForElement();
		  }
		  catch(Exception e)
			{
			  lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			  e.printStackTrace();
			  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	      
	  }

	  @When("^User Perform RunJob Operation for Imported Job$")
	  public void user_Perform_RunJob_Operation_for_Imported_Job() throws Throwable 
	  {
		  try
		  {
			  actual[7]=ip.runJob();
		  }
		  catch(Exception e)
			{
			  lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			  e.printStackTrace();
			  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	      
	  }

	  @When("^User Moves to the Imported Folder and Selects the Imported file$")
	  public void user_Moves_to_the_Imported_Folder_and_Selects_the_Imported_file() throws Throwable 
	  {
		  try
		  {
				actual[8]=ip.ClickOKonStatusReport();
				String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				
				actual[9]=ip.validateImport(fileName, releaseName);
				
				Actions act=new Actions(driver);
				act.doubleClick(ip.Imported).perform();
				bp.waitForElement();
				
				ip.selectImportedFile(fileName);
		  }
		  catch(Exception e)
			{
			  lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			  e.printStackTrace();
			  driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	      
	  }

	  @When("^User checks the Value for Checkbox Field$")
	  public void user_checks_the_Value_for_Checkbox_Field() throws Throwable 
	  {
		  try
		  {
			  actual[10]=tr.clickDetailButton();
			  bp.waitForElement();
			  actual[11]=ip.ValidateCheckBoxField();
			  bp.waitForElement();
			  tr.clickOnList();
			  bp.waitForElement();
			  Actions act=new Actions(driver);
			  act.doubleClick(ip.Imported).perform();
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

	  @Then("^CheckBox Should be In Unchecked Mode Successfully$")
	  public void checkbox_Should_be_In_Unchecked_Mode_Successfully() throws Throwable 
	  {
		  try
		  {
			  for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
			  log.info("Pass - CheckBox Should be In Unchecked Mode Successfully");
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
