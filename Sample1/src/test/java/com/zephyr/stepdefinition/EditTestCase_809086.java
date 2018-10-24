package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809086 extends LaunchBrowser 
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809086";
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the node page$")
	public void user_is_in_the_node_page() throws Throwable 
	{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		try
		{
			
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   
		   tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
//		   bp.waitForElement();
//		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"Nodes",17,0);
//		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Nodes",17,0);
//		   tr.addNode(name, desc);
//		   bp.waitForElement();
//		   bp.waitForElement();
//		   
//		   tr.doubleClickOnRelease(releaseName);
//		   bp.waitForElement();
		   
		   tr=new TestRepositoryPage(driver);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		   actual[3]=tr.navigateToNode(releaseName, phase);
		   
		   tr.addTestCase();
		   tr.addTestCase();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
		}
	}

	@When("^User sort the fields$")
	public void user_sort_the_fields() throws Throwable 
	{
		try
		{
			 bp=new BasePage();
			 bp.waitForElement();
		String[] sortName=new String[2];
		sortName[0]=Excel_Lib.getData(INPUT_PATH_2, "Sorting", 3, 0);
		sortName[1]=Excel_Lib.getData(INPUT_PATH_2, "Sorting", 5, 0);
		actual[4]=tr.sortingTestCase(sortName);
	    
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

	@When("^select few test cases$")
	public void select_few_test_cases() throws Throwable 
	{
		try
		{
	   
	    String[] testCases=new String[2];
	    testCases[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 2));
	    testCases[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 2));
		 ep=new ExportPage(driver);
		 actual[5]=ep.selectMultipleTestCaseFromGrid(testCases);
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

	@When("^copy test cases using clone button$")
	public void copy_test_cases_using_clone_button() throws Throwable 
	{
		try
		{
			actual[6]=tr.verifyPastTestCase();
			actual[7]=tr.cloneTestCase();
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

	@Then("^test cases should be copied$")
	public void test_cases_should_be_copied() throws Throwable {
	   
		try
		{
			actual[8]=tr.verifyPresentTestCase();
			for(int k=0;k<=actual.length-1;k++)
	 	     {
	 	      soft.assertEquals(actual[k], true);
	 	     }
	 	     soft.assertAll();
		}
		catch(Exception e)
		{
		lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
		}
	}


}
