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

public class Rename_SubSystem_809112 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ImportPage ip;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Rename_SubSystem_809112";
		boolean[] actual=new boolean[11];
		SoftAssert soft=new SoftAssert();
		
		@Given("^Lead is In Testrepository Page$")
		public void lead_is_In_Testrepository_Page() throws Throwable 
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
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep(); 
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

		@When("^Lead Moves to the Releasename$")
		public void lead_Moves_to_the_Releasename() throws Throwable 
		{
		    try
		    {
		    	tr=new TestRepositoryPage(driver);
				 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				 actual[3]= tr.doubleClickOnRelease(releaseName);
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

		@When("^Lead Creates Phase$")
		public void lead_Creates_Phase() throws Throwable 
		{
		    try
		    {
		    	String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
				String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
				String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
				actual[4]=tr.addNode(Name, Desc);
				bp.waitForElement();
			    tr.doubleClickOnRelease(releaseName);
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

		@When("^Lead Creates System in the Phase$")
		public void lead_Creates_System_in_the_Phase() throws Throwable 
		{
		    try
		    {
		    	bp=new BasePage();
		    	String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			    String all[]=new String[1];
			    all[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			    actual[5]= tr.navigateToNode(releaseName, all);
			    bp.waitForElement();
				String Name=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 0);
				String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 1);
				actual[6]= tr.addNode(Name, Desc);
				bp.waitForElement();
			    tr.doubleClickOnRelease(releaseName);
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

		@When("^Lead Creates SubSystem in the System$")
		public void lead_Creates_SubSystem_in_the_System() throws Throwable 
		{
		    try
		    {
		    	String all1[]=new String[2];
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			    all1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			    all1[1]=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 0);
			    actual[7]=tr.navigateToNode(releaseName, all1);
			    bp.waitForElement();
				String Name=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 10, 0);
				String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 10, 1);
				actual[8]=tr.addNode(Name, Desc);
				bp.waitForElement();
			    tr.doubleClickOnRelease(releaseName);
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

		@When("^Lead Rename the Subsystem$")
		public void lead_Rename_the_Subsystem() throws Throwable 
		{
		    try
		    {
		    	String all1[]=new String[3];
				String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			    all1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
			    all1[1]=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 0);
			    all1[2]=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 10, 0);
			    actual[9]=tr.navigateToNode(releaseName, all1);
			    bp.waitForElement();
			    tr.options.click();
			    bp.waitForElement();
			    tr.renameNode.click();
			    bp.waitForElement();
			    actual[10]=bp.eraseText(tr.renameField);
			    String Name=Excel_Lib.getData(INPUT_PATH, "Phases", 1, 0);
			    tr.renameField.sendKeys(Name);
			    bp.waitForElement();
			    tr.renameButton.click();
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

		@Then("^SubSystem should be Renamed Successfully$")
		public void subsystem_should_be_Renamed_Successfully() throws Throwable 
		{
		    try
		    {
		    	for(int k=0;k<=actual.length-1;k++)
		        {
		         soft.assertEquals(actual[k], true);
		        }
		        soft.assertAll();
		        
		    	log.info("Pass - SubSystem should be Renamed Successfully");
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
