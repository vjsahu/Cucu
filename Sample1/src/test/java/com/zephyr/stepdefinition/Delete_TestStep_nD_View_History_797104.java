package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Delete_TestStep_nD_View_History_797104 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	String fileName="Delete_TestStep_nD_View_History_797104";
	
	boolean[] actual=new boolean[8];
	 SoftAssert soft=new SoftAssert();
	@Given("^User is in the page of the TestRepository$")
	public void user_is_in_the_page_of_the_TestRepository() throws Throwable {
	    try
	    {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   //String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
		  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		   //String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		  actual[0]= pp.selectProject(projectName);
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

	@Given("^User Creates a node$")
	public void user_Creates_a_node() throws Throwable {
	    try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 5, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 5, 3);
		
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		actual[3]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		String navigation[]=new String[1];
		navigation[0]=p_Name1;
		bp.waitForElement();
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

	@When("^User creates a test case$")
	public void user_creates_a_test_case() throws Throwable {
	    try
	    {	
	    	//tr=new TestRepositoryPage(driver);
	    	bp=new BasePage();
	    	bp.waitForElement();
	    	tr=new TestRepositoryPage(driver);
	    	actual[5]=tr.addTestCase();
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

	@When("^User creates two steps$")
	public void user_creates_two_steps() throws Throwable {
	    try
	    {
		String[] stepDetail=new String[6];
		stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
		stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);
		stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
		stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
		stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		tr.clickDetailButton();
		bp.waitForElement();
		
		actual[6]=ctc.enterTestCaseStepDetail(stepDetail);
		bp.waitForElement();
		
		//ctc.clickStepSave.click();
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

	@When("^User views the step history$")
	public void user_views_the_step_history() throws Throwable {
	    try
	    {
	    bp=new BasePage();
		bp.waitForElement();
	    //ctc=new CreateTestCasePage(driver);
	   // ctc.stepDetailsHistory.click();
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

	@Then("^User delete a test step$")
	public void user_delete_a_test_step() throws Throwable {
	 
		  //bp=new BasePage();
		  //  bp.waitForElement();
		try
		{
		String testStepNo1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 9));
		
	    ctc=new CreateTestCasePage(driver);
	    ctc.stepDetail.click();
	    actual[7]=ctc.deleteTestSteps(testStepNo1);
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
	    
	    /*bp=new BasePage();
		bp.waitForElement();
		ctc.stepDetail.click();
		String testStepNo2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 9));
		ctc.deleteTestSteps(testStepNo2);
		
		ctc=new CreateTestCasePage(driver);
		ctc.stepDetailsHistory.click();
		*/
	}

	@Then("^User views the step history again$")
	public void user_views_the_step_history_again() throws Throwable {
	    try
	    {
//		ctc=new CreateTestCasePage(driver);
//		ctc.stepDetailsHistory.click();
		//ctc.verifyStepDetailHistory();
		for(int k=0;k<=actual.length-1;k++)
	     {
			System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	     tr.clickOnList();
		//log.info("step history viewed successfully");
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
