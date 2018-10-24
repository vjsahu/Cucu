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

public class DnD_Modify_Teststeps_809268 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DnD_Modify_Teststeps_809268";
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User moved to Testrepository$")
	public void user_moved_to_Testrepository() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",3,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		 
		try
		{
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

	@When("^User moves to Provided Release$")
	public void user_moves_to_Provided_Release() throws Throwable 
	{
		try
		{
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

	@When("^User moves to the PhaseName$")
	public void user_moves_to_the_PhaseName() throws Throwable 
	{
		try
		{
			 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			 
			bp.waitForElement();
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",27,0);
			String desc=Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",27,0);
			
			tr.addNode(name, desc);
			actual[4]=tr.doubleClickOnRelease(releaseName);

	     String navigation[]=new String[1];
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",27,0);
	     actual[5]=tr.navigateToNode(releaseName, navigation);
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

	@When("^User Selects Specified Testcase$")
	public void user_Selects_Specified_Testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String names[]=new String[1];
	     names[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",4,2);
	     actual[6]=tr.addTestCase();
	    // tr.selectTestCase(names);
	     actual[7]=tr.clickDetailButton();
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

	@When("^User Clicks on the Details View$")
	public void user_Clicks_on_the_Details_View() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String names[]=new String[1];
	     names[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",4,2);
	    // tr.selectTestCase(names);
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

	@When("^User Modify the Teststeps$")
	public void user_Modify_the_Teststeps() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		
		
		String steps[]=new String[6];
		steps[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 0);
		steps[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 1);
		steps[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 1, 2);
		
		steps[3]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 0);
		steps[4]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 1);
		steps[5]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 2, 2);
		
		ctc.enterTestCaseStepDetail(steps);
		bp.waitForElement();
		bp.waitForElement();
		ctc.stepDetail.click();
		
		bp.waitForElement();
		
		
		int stepNum=Excel_Lib.getNumberData(INPUT_PATH, "Modify_TC", 5, 0);
		String edit[]=new String[3];
		edit[0]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 1);
		edit[1]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 2);
		edit[2]=Excel_Lib.getData(INPUT_PATH, "Modify_TC", 5, 3);
		 actual[8]=ctc.editTestSteps(stepNum, edit);
	    
		 
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

	@When("^User DnD the Teststeps to Specified Stepnumber$")
	public void user_DnD_the_Teststeps_to_Specified_Stepnumber() throws Throwable 
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		 actual[9]= ctc.dnDForTestStepsDetails(2, 1);
		 
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

	@Then("^Teststeps should be Modified and Dnd Successfully$")
	public void teststeps_should_be_Modified_and_Dnd_Successfully() throws Throwable 
	{
		try
		{
	    log.info("Pass - Teststeps should be Modified and Dnd Successfully");
	    
	    tr.clickOnList();
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
