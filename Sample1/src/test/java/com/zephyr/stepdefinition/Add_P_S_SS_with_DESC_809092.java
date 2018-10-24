package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Add_P_S_SS_with_DESC_809092 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	
	boolean[] actual=new boolean[12];
	 SoftAssert soft=new SoftAssert();
	 

		String fileName="Add_P_S_SS_with_DESC_809092";
		
	@Given("^User is in the TestRepositoryPage$")
	public void user_is_in_the_TestRepositoryPage() throws Throwable 
	{
		try
		{
			
//		
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
			lb=new LaunchBrowser();
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
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
	    	e.printStackTrace();
			driver.close();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User navigates to ReleaseName$")
	public void user_navigates_to_ReleaseName() throws Throwable 
	{
		try
		{
		 tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			Relogin rl=new Relogin();
			e.printStackTrace();
			driver.close();
			rl.reLogin();
			throw e;
		}			

	}

		
	@When("^User Creates a Phase with Name and Description$")
	public void user_Creates_a_Phase_with_Name_and_Description() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		   actual[4]=tr.addNode(Name, Desc);
		   actual[5]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			e.printStackTrace();
			driver.close();
			rl.reLogin();
			throw e;
		}			

	}

	@Then("^Phase should be added Successfully with Name and Description$")
	public void phase_should_be_added_Successfully_with_Name_and_Description() throws Throwable 
	{
		try
		{
		log.info("Pass - Phase is Created with Name and Description Successfully");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			e.printStackTrace();
			driver.close();
			rl.reLogin();
			throw e;
		}
	}
	
	@When("^User navigates to Phases$")
	public void user_navigates_to_Phases() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	    String all[]=new String[1];
	    all[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		   actual[6]=tr.navigateToNode(releaseName, all);
	    BasePage bp=new BasePage();
	    bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}
	}
	
	@When("^User Creates a System with Name and Description$")
	public void user_Creates_a_System_with_Name_and_Description() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 0);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 1);
		   actual[7]=tr.addNode(Name, Desc);
		   actual[8]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}			
	}

	@Then("^System should be added Successfully$")
	public void system_should_be_added_Successfully() throws Throwable 
	{
		try
		{
	    log.info("Pass - System is created with Name and Description Successfully");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User navigates to System$")
	public void user_navigates_to_System() throws Throwable
	{
		try
		{
		String all1[]=new String[2];
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	    all1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
	    all1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 4, 0);
		   actual[9]=tr.navigateToNode(releaseName, all1);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}		

	}

	@When("^User Creates a Sub-System with Name and Description$")
	public void user_Creates_a_Sub_System_with_Name_and_Description() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 10, 0);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 10, 1);
		   actual[10]=tr.addNode(Name, Desc);
		   actual[11]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}		

	}
	
	
	@Then("^Sub-system should be added Successfully$")
	public void sub_system_should_be_added_Successfully() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	    log.info("Pass - Sub-System is Created with Name and Description Successfully");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			Relogin rl=new Relogin();
	    	//rl.takeSnapShot(driver,"E://Z_CloneWorkspace//zephy_5.1/target");
			driver.close();
			rl.reLogin();
			throw e;
		}
	}
}
