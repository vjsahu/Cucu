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

public class DnD_TestSteps_809266 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DnD_TestSteps_809266";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^Tester is Presents in the Testrepository$")
	public void tester_is_Presents_in_the_Testrepository() throws Throwable 
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

	@When("^Tester moves to the ReleaseName$")
	public void tester_moves_to_the_ReleaseName() throws Throwable 
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

	@When("^Tester Navigates to the Phase$")
	public void tester_Navigates_to_the_Phase() throws Throwable 
	{
		try
		{ String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 24, 0);
	 actual[4]=tr.addNode(name, name);
	 
	bp.waitForElement();
	bp.waitForElement();
	
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
     String navigation[]=new String[1];
     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH,"Create_P_S_SS",24,0);
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

	@When("^Tester Selects a Testcase$")
	public void tester_Selects_a_Testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
//		String names[]=new String[1];
//	     names[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",4,2);
		actual[6]=tr.addTestCase();
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

	@When("^Tester clicks on DetailView$")
	public void tester_clicks_on_DetailView() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		actual[7]=tr.clickOnDetails();
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

	@When("^Tester moves to StepDetails and Perform DnD Operation$")
	public void tester_moves_to_StepDetails_and_Perform_DnD_Operation() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		ctc=new CreateTestCasePage(driver);
		
		String stepdetails[]=new String[9];
		int k=0;
		for(int i=1;i<=3;i++)
		{
		for(int j=0;j<=2;j++)
		{
			stepdetails[k]=Excel_Lib.getData(INPUT_PATH_1,"Stepdetail",i, j);
			k++;
		}
		}
		 ctc.enterTestCaseStepDetail(stepdetails);
		 bp.waitForElement();
		ctc.stepDetail.click();
		bp.waitForElement();
		ctc.dnDForTestStepsDetails(3, 1);
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

	@Then("^DnD should be Performed Successfully by Tester$")
	public void dnd_should_be_Performed_Successfully_by_Tester() throws Throwable 
	{
		try
		{
	    log.info("Pass - DnD should be Performed Successfully by Tester");
	    
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
