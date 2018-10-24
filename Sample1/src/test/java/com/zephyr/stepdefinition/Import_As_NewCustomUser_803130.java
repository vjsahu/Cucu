package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Import_As_NewCustomUser_803130 extends LaunchBrowser
{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	CreateCustomFieldsPage ccf;
	ImportPage ip;
		boolean[] actual=new boolean[18];
		SoftAssert soft=new SoftAssert();
		
		@Given("^Login as Managager into Zephyr Application$")
		public void login_as_Managager_into_Zephyr_Application() throws Throwable 
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
	    	  ccf=new CreateCustomFieldsPage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep(); 
			   bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^Manager Moves to Administation Settings$")
		public void manager_Moves_to_Administation_Settings() throws Throwable 
		{
		    try
		    {
		    	ccf=new CreateCustomFieldsPage(driver);
		    	actual[3]=ccf.moveToCreateCustomUser();
		    	bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^Manager Cretes a CustomUser$")
		public void manager_Cretes_a_CustomUser() throws Throwable 
		{
		    try
		    {
		    	String firstName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,0);
		    	String lasTName=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,1);
		    	String type=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,2);
		    	String role=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,3);
		    	String email=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,4);
		    	String title=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,5);
		    	String location=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,6);
		    	actual[4]=ccf.createCustomUser(firstName, lasTName, type, role, email, title, location);
		    	bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^Manager Logout from the Zephyr Application$")
		public void manager_Logout_from_the_Zephyr_Application() throws Throwable 
		{
		    try
		    {
		    	actual[5]=pp.clickOnLogout();
		    	bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^New Custom User Login into Zephyr Application$")
		public void new_Custom_User_Login_into_Zephyr_Application() throws Throwable 
		{
			try
			{
				   lp=new LoginPage(driver);
				   String Uname=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,7);
				   String Pass=Excel_Lib.getData(INPUT_PATH,"Custom_Fields",10,7);
				   actual[6]=lp.enterUname(Uname);
				   actual[7]=lp.enterPass(Pass);
				   actual[8]=lp.clickOnLogin();
			}
			catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^New User Clicks on ImportIcon$")
		public void new_User_Clicks_on_ImportIcon() throws Throwable 
		{
		    try
		    {
		    	ip=new ImportPage(driver);
				   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
				   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				   actual[9]=pp.selectProject(projectName);
				   actual[10]=pp.selectRelease(releaseName);
				   rp= new ReleasePage(driver);
				   actual[11]=rp.clickOnTestRep(); 
				   bp.waitForElement();
				   tr.doubleClickOnRelease(releaseName);
				   bp.waitForElement();
				   actual[12]=ip.clickOnImport();
				   bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^New User Creates a Map$")
		public void new_User_Creates_a_Map() throws Throwable 
		{
			try
			{
				 bp=new BasePage();
					String mapname=Excel_Lib.getData(INPUT_PATH, "Create_Map", 10, 0);
					int rownum=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 10, 1);
					String[] ZephyrFields= new String[22];
					ZephyrFields[0]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 3);
					ZephyrFields[1]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 4);
					ZephyrFields[2]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 5);
					ZephyrFields[3]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 6);
					ZephyrFields[4]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 7);
					ZephyrFields[5]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 8);
					ZephyrFields[6]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 9);
					ZephyrFields[7]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 10);
					ZephyrFields[8]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 11);
					ZephyrFields[9]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 12);
					ZephyrFields[10]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 13);
					ZephyrFields[11]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 14);
					ZephyrFields[12]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 15);
					ZephyrFields[13]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 16);
					ZephyrFields[14]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 17);
					ZephyrFields[15]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 18);
					ZephyrFields[16]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 19);
					ZephyrFields[17]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 20);
					ZephyrFields[18]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 21);
					ZephyrFields[19]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 22);
					ZephyrFields[20]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 9, 23);
					ZephyrFields[21]=Excel_Lib.getData(INPUT_PATH, "Create_Map", 8, 24);
					String descrimi=Excel_Lib.getData(INPUT_PATH, "Create_Map", 2, 2);
					actual[13]=ip.updateMap(mapname, rownum,descrimi, ZephyrFields);
			}
			catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		    
		}

		@When("^New User Creates ImportJob$")
		public void new_User_Creates_ImportJob() throws Throwable 
		{
		    try
		    {
		    	String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 0);
				   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 12, 1);
				   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 11, 2);
				   actual[14]=ip.importTestCase(jobname, mapName, path);
				   bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@When("^New User Runs ImportJob$")
		public void new_User_Runs_ImportJob() throws Throwable 
		{
		    try
		    {
		    	actual[15]=ip.runJob();
		    	bp.waitForElement();
		    	actual[16]=ip.ClickOKonStatusReport();
		    	bp.waitForElement();
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}

		@Then("^File should be Successfully imported by New Custom User$")
		public void file_should_be_Successfully_imported_by_New_Custom_User() throws Throwable 
		{
		    try
		    {
		    	String fileName=Excel_Lib.getData(INPUT_PATH,"Import_Job",11,3);
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				actual[17]=ip.validateImport(fileName, releaseName);
				
				for(int k=0;k<=actual.length-1;k++)
			       {
			        soft.assertEquals(actual[k], true);
			       }
			       soft.assertAll();
		    	
		    	log.info("Pass - File should be Successfully imported by New Custom User");
		    }
		    catch(Exception e)
			{
				driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
		}	
}
