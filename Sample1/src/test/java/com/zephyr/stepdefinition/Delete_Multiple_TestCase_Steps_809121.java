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

public class Delete_Multiple_TestCase_Steps_809121 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	String fileName="Delete_Multiple_TestCase_Steps_809121";
	
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the page of Test Repository$")
	public void user_is_in_the_page_of_Test_Repository() throws Throwable {
	   
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
	
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

	@Given("^User navigates to a node having test case step details$")
	public void user_navigates_to_a_node_having_test_case_step_details() throws Throwable {
	 
		try
		{
			tr=new TestRepositoryPage(driver);
		
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 2, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 2, 3);
		
			
			actual[3]=tr.doubleClickOnRelease(releaseName);
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 2, 1);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 2, 4);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			bp.waitForElement();
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName,phase );
			//bp.waitForElement();
			bp.waitForElement();
			//bp.waitForElement();
			actual[7]=tr.addNode(s_Name1,s_Desc1);
			
			//tr.doubleClickOnRelease(releaseName);
			
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 2, 2);
			String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 2, 5);
			String[] system= new String[2];
			system[0]=p_Name1;
			system[1]=s_Name1;
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.navigateToNode(releaseName, system);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=tr.addNode(ss_Name1,ss_Desc1);
	 	 
	 	 
	 	
	 	//actual[3]=tr.navigateToNode(releaseName, fields);
	 	actual[11]=tr.addTestCase();
	 	//bp=new BasePage();
	 	bp.waitForElement();
	 	bp.waitForElement();
	 	actual[12]=tr.clickOnDetails();
	 	String[] stepDetail=new String[9];
		stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
		stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
		stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);
		stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
		stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
		stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
		stepDetail[6]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
		stepDetail[7]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
		stepDetail[8]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[13]=ctc.enterTestCaseStepDetail(stepDetail);
		ctc.stepDetail.getText();
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

	@When("^User go to details and selects a test case which is having multiple steps$")
	public void user_go_to_details_and_selects_a_test_case_which_is_having_multiple_steps() throws Throwable {
	   try
	   {	bp=new BasePage();
		   bp.waitForElement();
		   ctc=new CreateTestCasePage(driver);
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		  ctc.stepDetail.click();
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

	@When("^User selects step number three to delete$")
	public void user_selects_step_number_three_to_delete() throws Throwable {
	   try
	   {
		String testStepNo1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 9));
	    //String testStepNo1=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 3, 9);
		
	    ctc=new CreateTestCasePage(driver);
	    bp=new BasePage();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	   // CreateTestCasePage_POM ctcp=new CreateTestCasePage_POM(driver);
	    actual[14]=ctc.deleteTestSteps(testStepNo1);
	    ctc.stepDetail.getText();
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

	@When("^User again selects step number two to delete$")
	public void user_again_selects_step_number_two_to_delete() throws Throwable {
	    try
	    {
		bp=new BasePage();
		
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		bp.waitForElement();
		//bp.waitForElement();
		//bp.waitForElement();
		ctc.stepDetail.click();
		String testStepNo2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 9));
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		actual[15]=ctc.deleteTestSteps(testStepNo2);
		ctc.stepDetail.getText();
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

	
	@Then("^User Should be able to view the steps, data and expected results and deletes multiple steps successfully$")
	public void user_Should_be_able_to_view_the_steps_data_and_expected_results_and_deletes_multiple_steps_successfully() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
	    		System.out.println(actual[k]);
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
