package com.zephyr.stepdefinition;

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

public class Copy_ImportedTC_Release_803036 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Copy_ImportedTC_Release_803036";
		boolean[] actual=new boolean[13];
		SoftAssert soft=new SoftAssert();
		
		@Given("^User is in Repository Page$")
		public void user_is_in_Repository_Page() throws Throwable 
		{
		    try
		    {
//		  		lb=new LaunchBrowser();
//			   lb.preCond();
//			   lp=new LoginPage(driver);
//			   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//			   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//			   lp.enterUname(Uname);
//			   lp.enterPass(Pass);
//			   lp.clickOnLogin();
	    	  //ctc=new CreateTestCasePage(driver);
		    	bp=new BasePage();
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			 	ctc=new CreateTestCasePage(driver);
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

		@When("^User moves to the Releaename$")
		public void user_moves_to_the_Releaename() throws Throwable 
		{
		    try
		    {
		    	ip= new ImportPage(driver);
				 bp=new BasePage();
				 tr=new TestRepositoryPage(driver);
				 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				 actual[3]=tr.doubleClickOnRelease(releaseName);
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

		@When("^User Clicks on importIcon$")
		public void user_Clicks_on_importIcon() throws Throwable 
		{
		    try
		    {
		    	String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
				 String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
				 actual[4]=tr.addNode(Name, Desc);
				 bp.waitForElement();
				 actual[5]=ip.clickOnImport();
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

		@When("^User Creates Map with Matching Fields$")
		public void user_Creates_Map_with_Matching_Fields() throws Throwable 
		{
		    try
		    {
		    	bp=new BasePage();
		    	String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 0);
				int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 10, 1);
		    	String[] ZephyrFields= new String[23];
				ZephyrFields[0]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 3);
				ZephyrFields[1]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 4);
				ZephyrFields[2]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 5);
				ZephyrFields[3]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 6);
				ZephyrFields[4]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 7);
				ZephyrFields[5]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 8);
				ZephyrFields[6]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 9);
				ZephyrFields[7]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 10);
				ZephyrFields[8]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 11);
				ZephyrFields[9]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 12);
				ZephyrFields[10]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 13);
				ZephyrFields[11]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 14);
				ZephyrFields[12]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 15);
				ZephyrFields[13]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 16);
				ZephyrFields[14]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 17);
				ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 99);
				ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 99);
				ZephyrFields[17]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 19);
				ZephyrFields[18]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 20);
				ZephyrFields[19]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 21);
				ZephyrFields[20]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 22);
				ZephyrFields[21]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 23);
				ZephyrFields[22]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 13, 24);
				String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
				actual[6]=ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
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

		@When("^User Creates Import Job for the Created Map$")
		public void user_Creates_Import_Job_for_the_Created_Map() throws Throwable 
		{
		    try
		    {
		    	String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 0);
				   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 1);
				   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 2);
				   actual[7]=ip.importTestCase(jobname, mapName, path);
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

		@When("^User runs the Imported Job$")
		public void user_runs_the_Imported_Job() throws Throwable 
		{
		    try
		    {
		    	 actual[8]=ip.runJob();
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

		@When("^User navigates to the Imported File$")
		public void user_navigates_to_the_Imported_File() throws Throwable 
		{
		    try
		    {
		    	actual[9]=ip.ClickOKonStatusReport();
				String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				actual[10]=ip.validateImport(fileName, releaseName);
				
				
				ip.selectImportFile1(fileName);
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

		@When("^User Copy the Imported Node$")
		public void user_Copy_the_Imported_Node() throws Throwable 
		{
		    try
		    {
		    	tr=new TestRepositoryPage(driver);
		    	tr.options.click();
		    	bp.waitForElement();
		    	tr.copyImportedFile.click();
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

		@When("^User Creates Phase in the Release$")
		public void user_Creates_Phase_in_the_Release() throws Throwable 
		{
		    try
		    {
		    	String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		    	String navigation[]=new String[1];
			    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			    actual[11]=tr.navigateToNode(releaseName, navigation);
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

		@When("^User Pastes the File in Created Phase$")
		public void user_Pastes_the_File_in_Created_Phase() throws Throwable 
		{
		    try
		    {
		    	actual[12]=tr.pasteNode();
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

		@Then("^File should be copied successfully to the Phase of Current Release$")
		public void file_should_be_copied_successfully_to_the_Phase_of_Current_Release() throws Throwable 
		{
		    try
		    {
		    	for(int k=0;k<=actual.length-1;k++)
		        {
		         soft.assertEquals(actual[k], true);
		        }
		        soft.assertAll();
		        
		        log.info("Pass- File should be copied successfully to the Phase of Current Release");
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
