package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809414 extends LaunchBrowser 
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809414";
	
	boolean[] actual=new boolean[7];
	   SoftAssert soft=new SoftAssert();
	   
	@When("^User Add a node in release$")
	public void user_Add_a_node_in_release() throws Throwable
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);

		String nodeNmae=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 4, 0);
		String nodeDesc=Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 4, 1);
		
	   tr=new TestRepositoryPage(driver);
	   actual[0]=tr.doubleClickOnRelease(releaseName);
	   actual[1]=tr.addNode(nodeNmae, nodeDesc);
	   bp.waitForElement();
	   actual[2]=tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	   String[] node=new String[1];
	   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "NodeAdd", 4, 0);
		
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

	@When("^Add test case in the node and$")
	public void add_test_case_in_the_node_and() throws Throwable {
		try
		{
			actual[4]= tr.addTestCase();
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

	@When("^naviagte to detail view$")
	public void naviagte_to_detail_view() throws Throwable {
		try
		{
			actual[5]=tr.clickDetailButton();
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

	@When("^add test step,test data and expected result$")
	public void add_test_step_test_data_and_expected_result() throws Throwable 
	{
		try
		{
		String[] stepDetail=new String[15];
		int k=0;
		for(int j=1;j<=5;j++)
		{
		for(int i=0;i<=2;i++)
		{
		stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2, "Stepdetails", j, i);
		k++;
		}
		}
	    ctc=new CreateTestCasePage(driver);
	    actual[6]=ctc.enterTestCaseStepDetail(stepDetail);
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

	@Then("^test case should be created with stepDetails$")
	public void test_case_should_be_created_with_stepDetails() throws Throwable
	{

		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	   log.info("Test Case Created With Step Details");
	   
	   tr.clickOnList();
	}

}
