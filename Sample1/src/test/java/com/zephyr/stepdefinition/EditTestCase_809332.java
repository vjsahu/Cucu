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

public class EditTestCase_809332 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	int pastTestCaseCount;
	int presentTestCaseCount;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809272";
	
	boolean[] actual=new boolean[13];
	   SoftAssert soft=new SoftAssert();
	
	@Given("^User is the node page$")
	public void user_is_the_node_page() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		  
		   
		   tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
		   String name=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   String desc=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   tr.addNode(name, desc);
		   bp.waitForElement();
		   tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   String[] node=new String[1];
		   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		   actual[3]=tr.navigateToNode(releaseName, node);
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

	@When("^User Add a test case$")
	public void user_Add_a_test_case() throws Throwable 
	{
		try
		{
			actual[4]=tr.verifyPastTestCase();
		//System.out.println("In add="+pastTestCaseCount);
	    log.info("Test Case Count Before Adding Test Case-"+pastTestCaseCount );
	    actual[5]=tr.addTestCase();
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

	@Then("^test case count should be increased$")
	public void test_case_count_should_be_increased() throws Throwable 
	{
		
		try
		{
			actual[6]=tr.verifyPresentTestCase();
	    log.info("Test Case Count After Adding Test Case-"+presentTestCaseCount );
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

	@When("^User clone a test case$")
	public void user_clone_a_test_case() throws Throwable 
	{
		try
		{
			actual[7]=tr.verifyPastTestCase();
	 System.out.println("In clone Before-"+pastTestCaseCount);
	 String[] testCase=new String[2];
	 testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 2));
	 testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 2));
	 ep=new ExportPage(driver);
	 actual[8]=ep.selectMultipleTestCaseFromGrid(testCase);
	 
	 
	 actual[9]=tr.cloneTestCase();
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

	@When("^User delete a test case$")
	public void user_delete_a_test_case() throws Throwable 
	{
		try
		{
//		String[] testCase=new String[2];
//		 testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 2));
//		 testCase[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 2, 2));
//		 ep.selectMultipleTestCaseFromGrid(testCase);
		tr.verifyPastTestCase();
		System.out.println(pastTestCaseCount);
		String[] testCase1=new String[1];
		testCase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestCaseNo", 1, 2));
		actual[10]=ep.selectMultipleTestCaseFromGrid(testCase1);
		actual[11]=tr.deleteTestCase();
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

	@Then("^test case count should be decreased$")
	public void test_case_count_should_be_decreased() throws Throwable {
	    try
	    {
	    	actual[12]=tr.verifyPresentTestCase();
	    	
	    	 for(int k=0;k<=actual.length-1;k++)
			    {
			    	soft.assertEquals(actual[k], true);
			    }
		    	soft.assertAll();
			 log.info("Edited");
			 
	    log.info("Test Case Count After deleting Test Case-"+presentTestCaseCount );
	    if((pastTestCaseCount-1)==presentTestCaseCount)
	    {
	    	log.info("Test Case count Decreased");
	    }
	    bp=new BasePage();
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

	
	

}
