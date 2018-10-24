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

public class EditTestCase_809069 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809069";
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is on the test Case Page$")
	public void user_is_on_the_test_Case_Page() throws Throwable 
	{
		try
		{
//		   lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   
		   tr=new TestRepositoryPage(driver);
		   actual[3]=tr.doubleClickOnRelease(releaseName);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 3, 0);
		   actual[4]=tr.navigateToNode(releaseName, phase);
		   bp.waitForElement();
		   String[] testCase=new String[1];
		   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "EditTestCase", 1, 0));
		   ep=new ExportPage(driver);
		   actual[5]=ep.selectMultipleTestCaseFromGrid(testCase);
		   bp.waitForElement();
		   //actual[4]=tr.selectTestCase(testCase);
		   actual[6]=tr.clickDetailButton();
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

	@When("^User change the priority to \"([^\"]*)\"$")
	public void user_change_the_priority_to(String priority) throws Throwable 
	{
		try
		{
	   ctc=new CreateTestCasePage(driver);
	   String[] details=new String[4];
	   details[0]=priority;
	   System.out.println(priority);
	   details[1]="";
	   details[2]="";
	   details[3]="";
	   
	   actual[7]=ctc.enterTestCaseDetail(details);
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

	@Then("^priority should be changed$")
	public void priority_should_be_changed() throws Throwable 
	{
 try
 {
		 for(int k=0;k<=actual.length-1;k++)
 	     {
 	      soft.assertEquals(actual[k], true);
 	     }
 	     soft.assertAll();
	 log.info("Priority Successfully Edited"); 
	 
	 
	 tr.clickOnList();
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
