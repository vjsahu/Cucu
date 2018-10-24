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

public class Import_CopyImportedNode_To_P_S_SS_797102 extends LaunchBrowser
{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ImportPage ip;
	String fileName="Import_CopyImportedNode_To_P_S_SS_797102";
		boolean[] actual=new boolean[13];
		SoftAssert soft=new SoftAssert();
	  
		@Given("^User is present in the Testrepository$")
		public void user_is_present_in_the_Testrepository() throws Throwable 
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
			   bp=new BasePage();
	    	  ctc=new CreateTestCasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   bp.waitForElement();
			   actual[0]=pp.selectProject(projectName);
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   
			   bp.waitForElement();
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

		@When("^User is Clicks on Importicon$")
		public void user_is_Clicks_on_Importicon() throws Throwable 
		{
		    try
		    {
		    	 ip= new ImportPage(driver);
				 bp=new BasePage();
				 tr=new TestRepositoryPage(driver);
				 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				 actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				 String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
				 String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
				 actual[4]=tr.addNode(Name, Desc);
				 bp.waitForElement();
				 actual[5]=ip.clickOnImport();
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

		@When("^User Creates map with matching Custom fields$")
		public void user_Creates_map_with_matching_Custom_fields() throws Throwable 
		{
		    try
		    {
		    	 bp=new BasePage();
					String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 10, 0);
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
					//actual[5]=ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
					actual[6]=ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
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

		@When("^User Creates the Import Job$")
		public void user_Creates_the_Import_Job() throws Throwable 
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
		    	lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
		    	driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^User Runs Imported Job$")
		public void user_Runs_Imported_Job() throws Throwable 
		{
		    try
		    {
		    	 actual[8]=ip.runJob();
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

		@When("^User Navigates to Imported Folder$")
		public void user_Navigates_to_Imported_Folder() throws Throwable 
		{
		    try
		    {
		    	actual[9]=ip.ClickOKonStatusReport();
				String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				actual[10]=ip.validateImport(fileName, releaseName);
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

		@When("^User Copy the Imported File$")
		public void user_Copy_the_Imported_File() throws Throwable 
		{
		    try
		    {
		    	String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
		    	ip.selectImportFile1(fileName);
		    	bp.waitForElement();
		    	tr.options.click();
		    	bp.waitForElement();
		    	tr.copyImportedFile.click();
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

		@When("^User Paste the Imported node in Created Phase$")
		public void user_Paste_the_Imported_node_in_Created_Phase() throws Throwable 
		{
		    try
		    {
		    	String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		    	String navigation[]=new String[1];
			    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			    bp.waitForElement();
			    actual[11]=tr.navigateToNode(releaseName, navigation);
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

		@Then("^Imported File is copied to the Phase Successfully$")
		public void imported_File_is_copied_to_the_Phase_Successfully() throws Throwable 
		{
		    try
		    {
		    	actual[12]=tr.pasteNode();
		    	bp.waitForElement();
		    	for(int k=0;k<=actual.length-1;k++)
		        {
		         soft.assertEquals(actual[k], true);
		        }
		        soft.assertAll();
		    	log.info("Pass - Imported File is copied to the Phase Successfully");
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
