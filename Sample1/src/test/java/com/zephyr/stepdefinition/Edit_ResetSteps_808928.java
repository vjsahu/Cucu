package com.zephyr.stepdefinition;

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

public class Edit_ResetSteps_808928 extends LaunchBrowser
{
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_ResetSteps_808928";
	
	@Given("^User in the Repository Page$")
	public void user_in_the_Repository_Page() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();
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

	@When("^Add a Node and testcase$")
	public void add_a_Node_and_testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();

	    //Creating Phase
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",5,0);
	    String pDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",5,1);
	    tr.addNode(pName, pDesc);
	    bp.waitForElement();
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    bp.waitForElement();
	    String navigation[]=new String[1]; 
	     navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",5,0);
	     tr.navigateToNode(releaseName, navigation);
	    bp.waitForElement();
	    
	    tr=new TestRepositoryPage(driver);
	    tr.addTestCase();
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

	@When("^Click on detail and Enter Teststeps$")
	public void click_on_detail_and_Enter_Teststeps() throws Throwable 
	{
		try
		{
		tr.clickDetailButton();
	    bp.waitForElement();
	    
	    String[] stepDetails=new String[9];
	    stepDetails[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 0);
	    stepDetails[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 1);
	    stepDetails[2]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 2);
	   
	    stepDetails[3]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 3);
	    stepDetails[4]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 4);
	    stepDetails[5]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 5);
	    
	    stepDetails[6]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 6);
	    stepDetails[7]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 7);
	    stepDetails[8]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 8);
	    ctc=new CreateTestCasePage(driver);
	    ctc.enterTestCaseStepDetail(stepDetails);
	    bp=new BasePage();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    ctc.stepDetail.click();
	    bp.waitForElement();
	    int stepNum=3;
	    String edit[]=new String[3];
	    edit[0]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 6);
	    edit[1]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 4);
	   edit[2]= Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 8);
	    ctc.editTestSteps(stepNum, edit);
	    ctc.stepDetail.click();
	    bp.waitForElement();
	    tr.clickOnList();
	    bp.waitForElement();
//	    WebElement ele=driver.findElement(By.xpath("//span[@placeholder='Enter Step']"));
//	    ele.click();
//	    ele.sendKeys("hiiii");
//	    Actions a1=new Actions(driver);
//		a1.sendKeys(Keys.TAB).perform();
//		a1.sendKeys("hello").perform();
//		a1.sendKeys(Keys.TAB).perform();
//		a1.sendKeys("how").perform();
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

	@When("^Re_Enter step Details and click on cancel$")
	public void re_enter_step_Details_and_click_on_cancel() throws Throwable 
	{
//		 Actions a1=new Actions(driver);
//			a1.sendKeys(Keys.TAB).perform();
//			a1.sendKeys("hello").perform();
//			a1.sendKeys(Keys.TAB).perform();
//			a1.sendKeys("how").perform();
//			  stepDetails[6]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 6);
//			    stepDetails[7]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 7);
//			    stepDetails[8]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 8);
//			    ctc=new CreateTestCasePage(driver);
//			    ctc.enterTestCaseStepDetail(stepDetails);
	}

	@Then("^Should reset the steps$")
	public void should_reset_the_steps() throws Throwable
	{
		//Actions a1=new Actions(driver);
//			a1.sendKeys(Keys.TAB).perform();
//			a1.sendKeys("hello").perform();
//			a1.sendKeys(Keys.TAB).perform();
//			a1.sendKeys("how").perform();
//			  stepDetails[6]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 6);
//			    stepDetails[7]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 7);
//			    stepDetails[8]=Excel_Lib.getData(INPUT_PATH_4, "testCaseStepDetails", 1, 8);
//			    ctc=new CreateTestCasePage(driver);
//			    ctc.enterTestCaseStepDetail(stepDetails);
	}
}
