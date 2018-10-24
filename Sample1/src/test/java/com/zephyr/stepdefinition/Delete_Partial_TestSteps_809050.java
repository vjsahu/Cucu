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

public class Delete_Partial_TestSteps_809050 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	String fileName="Delete_Partial_TestSteps_809050";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the page of the TestRepository window$")
	public void user_is_in_the_page_of_the_TestRepository_window() throws Throwable {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	
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

	@Given("^User creates a node in release$")
	public void user_creates_a_node_in_release() throws Throwable {
		try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 9, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 9, 3);
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		actual[3]=tr.doubleClickOnRelease(releaseName);
		//bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);
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

	@When("^User creates a test case under phase$")
	public void user_creates_a_test_case_under_phase() throws Throwable {
		try
		{

			bp.waitForElement();
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
	
	@When("^User creates a test steps$")
	public void user_creates_a_test_steps() throws Throwable {
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
		ctc.stepDetail.click();
		bp.waitForElement();
		//ctc.clickStepSave.click();
		//ctc.stepDetail.click();
		//ctc.enterTestCaseStepDetail(stepDetail);//
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

	@When("^User deletes test steps$")
	public void user_deletes_test_steps() throws Throwable {
	    
		
		int stepNum=Excel_Lib.getNumberData(INPUT_PATH_3,"Requirements" , 1, 0);
		int stepNum1=Excel_Lib.getNumberData(INPUT_PATH_3,"Requirements" , 2, 0);
		String[] edit=new String[2];
		edit[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		edit[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
		/*edit[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
		edit[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);*/
		//edit[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		//String[] testSteps=new String[6];
		//testSteps[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		//bp=new BasePage();
		//bp.waitForElement();
		/*String[] testSteps=new String[6];//
		testSteps[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		testSteps[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
		testSteps[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);//*/
		bp=new BasePage();
		bp.waitForElement();
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		//bp.waitForElement();
		actual[7]=ctc.editTeststep(stepNum, edit);
		bp.waitForElement();
		//bp.waitForElement();
		ctc.stepDetail.click();
		bp.waitForElement();
		bp.waitForElement();
		actual[8]=ctc.editTeststep(stepNum1, edit);
		bp.waitForElement();
	}

	@Then("^User successfully delete test steps$")
	public void user_successfully_delete_test_steps() throws Throwable {
		 try
		    {
		    	for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			     soft.assertAll();
			log.info("User Should be able to view the steps, data and expected results and deletes multiple steps successfully");
			bp.waitForElement();
	    	tr.clickOnList();
	    	bp.waitForElement();
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
