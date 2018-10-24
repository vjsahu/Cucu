package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.TestRepositoryPage_POM;
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

public class Clone_Morethan_200TC_809420 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	CreateTestCasePage ctc;
	TestRepositoryPage_POM trPOM;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Clone_Morethan_200TC_809420";
	
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User moves to the TestcaseRepository$")
	public void user_moves_to_the_TestcaseRepository() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
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

	@When("^User navigates to release$")
	public void user_navigates_to_release() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
	     //bp.waitForElement();
	     String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 1);
		actual[4]=tr.addNode(Name, Desc);
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

	@When("^User moves to Phase$")
	public void user_moves_to_Phase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[5]=tr.doubleClickOnRelease(releaseName);
	     bp.waitForElement();
	     String navigation[]=new String[1];
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
	     actual[6]=tr.navigateToNode(releaseName, navigation);
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

	@When("^User Selects >Two Hundred testcases$")
	public void user_Selects_Two_Hundred_testcases() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		trPOM=new TestRepositoryPage_POM(driver);
		for(int i=1;i<=10;i++)
		{
			actual[7]=tr.addTestCase();
		bp.waitForElement();
		}
		tr.selectallTestCase();
		
		for(int j=1;j<=9;j++)
		{
			bp.waitForElement();
			actual[8]=tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		}
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

	@When("^User Performs the Clone Operation$")
	public void user_Performs_the_Clone_Operation() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String start=trPOM.initCount.getText();
		System.out.println(start);
		bp.waitForElement();
		if(start=="100")
		{
			log.info("Pass - '100' Testcases are created successfully");
		}
		tr.selectallTestCase();
		bp.waitForElement();
		bp.waitForElement();
		actual[6]=tr.cloneTestCase();
		bp.waitForElement();
		bp.waitForElement();
		String end=trPOM.finalCount.getText();
		System.out.println(end);
		bp.waitForElement();
		if(start=="200")
		{
			log.info("Pass - '200' Testcases are created successfully");
		}
	    bp.waitForElement();
	    String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	    tr.doubleClickOnRelease(releaseName);
	    String navigation[]=new String[1];
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 1, 0);
	     actual[9]= tr.navigateToNode(releaseName, navigation);
	     actual[10]=tr.deleteNode();
	    
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

	@Then("^>Two Hundred Testcases should be Cloned Successfully$")
	public void two_Hundred_Testcases_should_be_Cloned_Successfully() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
		log.info("Pass - >Two Hundred Testcases should be Cloned Successfully");
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
