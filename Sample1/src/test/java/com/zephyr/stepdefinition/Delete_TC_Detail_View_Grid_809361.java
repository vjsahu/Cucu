package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Delete_TC_Detail_View_Grid_809361 extends LaunchBrowser
{
	LaunchBrowser lb;
	 LoginPage lp;
	 ProjectPage pp;
	 ReleasePage rp;
	 TestRepositoryPage tr;
	 NavigationPage np;
	 BasePage bp;
	 ExportPage exp;
	 String fileName="Delete_TC_Detail_View_Grid_809361";
	 
	 boolean[] actual=new boolean[6];
		SoftAssert soft=new SoftAssert();
		
	@Given("^User present in test repository page$")
	public void user_present_in_test_repository_page() throws Throwable 
	{
//		 lb=new LaunchBrowser();
//	     lb.preCond();
//	     
//	     lp=new LoginPage(driver);
//	     String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
//	     String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
//	     lp.enterUname(Uname);
//	     lp.enterPass(Pass);
//	     lp.clickOnLogin();
	 
		try
		{
	     pp=new ProjectPage(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	     String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
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

	@Given("^User creates a Node$")
	public void user_creates_a_Node() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 4, 0);
		  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 4, 3);
		  
		  tr=new TestRepositoryPage(driver);
		  bp=new BasePage();
		  bp.waitForElement();
		  actual[3]=tr.doubleClickOnRelease(releaseName);
		 // bp.waitForElement();
		  bp.waitForElement();
		 actual[4]= tr.addNode(p_Name1,p_Desc1);
		 tr.doubleClickOnRelease(releaseName);
			String navigation[]=new String[1];
			navigation[0]=p_Name1;
			tr.navigateToNode(releaseName, navigation);
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

	@When("^User creates three test cases$")
	public void user_creates_three_test_cases() throws Throwable {
		
		try
		{
			for(int i=0;i<=2;i++)
		
		  {
				//bp.waitForElement();
				//bp.waitForElement();
				actual[5]=tr.addTestCase();
		  }
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

	@When("^User Navigates to Detail View and Delete a test case$")
	public void user_Navigates_to_Detail_View_and_Delete_a_test_case() throws Throwable {
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		 tr.clickDetailButton();
		exp=new ExportPage(driver);
		String[] testcaseNo=new String[1];
		testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 4));
		exp.selectMultipleTestCaseFromGrid(testcaseNo);
	    
	     bp.waitForElement();
	     tr.verifyPastTestCase();
	     bp.waitForElement();
	     bp.waitForElement();
	    tr.deleteTestcase.click();
	    bp.waitForElement();
	    tr.clicksDelete.click();
	   // bp.waitForElement();
	    //tr.verifyPresentTestCase();
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

	@When("^User Navigates again to list view and view the test case grid$")
	public void user_Navigates_again_to_list_view_and_view_the_test_case_grid() throws Throwable {
	  try
	  {
		  bp.waitForElement();
		  bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		tr.verifyPresentTestCase();
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

	@Then("^test case should be displayed in Grid in list view successfully$")
	public void test_case_should_be_displayed_in_Grid_in_list_view_successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("TestCase should be displayed in Grid in list view successfully");
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


}
