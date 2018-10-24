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

public class Edit_TestStep_797103 extends LaunchBrowser
{
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTeststeps_797103";
	
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in then testrepository page$")
	public void user_in_then_testrepository_page() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}

	@When("^add node and testcase$")
	public void add_node_and_testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    //bp.waitForElement();

	    //Creating Phase
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",4,0);
	    String pDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",4,1);
	    actual[4]=tr.addNode(pName, pDesc);
	    bp.waitForElement();
	    
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",4,0);
	    tr.navigateToNode(releaseName, phase);
	    
	    
	    //tr=new TestRepositoryPage(driver);
	    tr.addTestCase();
	    tr.clickDetailButton();
	    bp.waitForElement();
	    
	    String[] stepDetails=new String[3];
	    stepDetails[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 0);
	    stepDetails[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 1);
	    stepDetails[2]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 2);
	    ctc=new CreateTestCasePage(driver);
	    actual[5]=ctc.enterTestCaseStepDetail(stepDetails);
	    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}

	@When("^view test step history and modify test step$")
	public void view_test_step_history_and_modify_test_step() throws Throwable
	{
		try
		{
		ctc=new CreateTestCasePage(driver);
		//ctc.clickOnStepDetailHistory.click();
		bp=new BasePage();
		bp.waitForElement(); 
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}

	@Then("^should be able view latest history$")
	public void should_be_able_view_latest_history() throws Throwable
	{
		try
		{
		//String stepHistory=ctc.viewStepDetailHistory.getText();
		//bp.waitForElement();
//		ctc.stepDetail.click();
//		bp.waitForElement();	
		//System.out.println(stepHistory);
				//log.info(stepHistory);
				//modify test step
				
				 //   ctc.enterTestCaseStepDetail(stepDetails);
//				    int n=1;
//				    ctc.editTeststeps(n, stepDetails);
				    
				   // ctc.clickOnStepDetailHistory.click();
				    //bp.waitForElement();
				   
				    
				   
				    for(int k=0;k<=actual.length-1;k++)
				     {
				      soft.assertEquals(actual[k], true);
				     }
				     soft.assertAll();
	}catch (Exception e) 
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
