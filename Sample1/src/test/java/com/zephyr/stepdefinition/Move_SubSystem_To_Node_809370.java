package com.zephyr.stepdefinition;

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

public class Move_SubSystem_To_Node_809370 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Move_SubSystem_To_Node_809370";
	
	@Given("^User moved to TestRepositoryPage$")
	public void user_moved_to_TestRepositoryPage() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LUname");
//		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"LPass");
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
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

	@When("^User Moves to Release$")
	public void user_Moves_to_Release() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
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

	@When("^User Creates two Phase and one System in each System$")
	public void user_Creates_two_Phase_and_one_System_in_each_System() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,0);
		String Desc=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,1);
		tr.addNode(Name, Desc);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		tr.doubleClickOnRelease(releaseName);
		String navigation[]=new String[1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,0);
		tr.navigateToNode(releaseName, navigation);
		String Name1=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",4,0);
		String Desc1=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",4,1);
		tr.addNode(Name1, Desc1);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,0);
		String Desc2=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,1);
		tr.addNode(Name2, Desc2);
		tr.doubleClickOnRelease(releaseName);
		String navigation1[]=new String[1];
		navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,0);
		tr.navigateToNode(releaseName, navigation1);
		String Name3=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",5,0);
		String Desc3=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",5,1);
		tr.addNode(Name3, Desc3);
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

	@When("^User Moves System of One Phase to another Phase$")
	public void user_Moves_System_of_One_Phase_to_another_Phase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String navigation[]=new String[2];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",2,0);
		navigation[1]=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",5,0);
		tr.navigateToNode(releaseName, navigation);
		tr.moveNode();
		tr.doubleClickOnRelease(releaseName);
		String navigation3[]=new String[2];
		navigation3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",1,0);
		navigation3[1]=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",4,0);
		tr.navigateToNode(releaseName, navigation);
		tr.pasteNode();
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

	@Then("^System should be moved successfully to Phase$")
	public void system_should_be_moved_successfully_to_Phase() throws Throwable 
	{
		try
		{
	    log.info("Pass - System should be moved successfully to Phase");
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
