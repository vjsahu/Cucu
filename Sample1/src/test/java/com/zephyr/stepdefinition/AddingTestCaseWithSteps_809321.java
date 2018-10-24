package com.zephyr.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingTestCaseWithSteps_809321 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	
	
	String fileName="AddingTestCaseWithSteps_809321";
	@Given("^Tester is in Test Case Page of Subsystem$")
	public void tester_is_in_Test_Case_Page_of_Subsystem() throws Throwable {
		   
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		  
		try
		{
			lb=new LaunchBrowser();
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep(); 
		   tr=new TestRepositoryPage(driver);
		   
		   tr.doubleClickOnRelease(releaseName);
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 0);
		   String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 0);
		   tr.addNode(Name, Desc);
		   
		   tr.doubleClickOnRelease(releaseName);
		   
		   String navigation[]=new String[1];
		   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 0);
		   tr.navigateToNode(releaseName, navigation);
		   String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 1);
		   String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 1);
		   tr.addNode(Name1, Desc1);
		   tr.doubleClickOnRelease(releaseName);
		   
		   String navigation1[]=new String[2];
		   navigation1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 0);
		   navigation1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 1);
		   tr.navigateToNode(releaseName, navigation1);
		   String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 2);
		   String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 2);
		   tr.addNode(Name2, Desc2);
		   tr.doubleClickOnRelease(releaseName);
		   
		   String[] subsystem=new String[3];
		   subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 0);
		   subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 1);
		   subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Phases",6, 2);
		   actual[3]= tr.navigateToNode(releaseName,subsystem);
		}
		catch(Exception e)
		{ lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User click on Add Tab$")
	public void user_click_on_Add_Tab() throws Throwable
	{
		try
		{
			actual[4]= tr.addTestCase();
			actual[5]= tr.clickDetailButton();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^Change the Summary Of Test Case$")
	public void change_the_Summary_Of_Test_Case() throws Throwable 
	{
		try
		{
		Actions a2=new Actions(driver);
		for(int i=1;i<=3;i++)
		  {
				a2.sendKeys(Keys.DOWN).perform();
		  }
	    ctc=new CreateTestCasePage(driver);
	    String testCaseName=Excel_Lib.getData(INPUT_PATH_1, "TC_Name", 1, 0);
	    String testCaseDesc=Excel_Lib.getData(INPUT_PATH_1, "TC_Name", 1, 1);
	    actual[6]= ctc.enterTestCaseNameAndDesc(testCaseName,testCaseDesc);
	 
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		}
		

	@When("^Enters the Step Details Field$")
	public void enters_the_Step_Details_Field() throws Throwable
	{
		try
		{
		String stepdetails[]=new String[9];
		int k=0;
		for(int i=1;i<=3;i++)
		{
		for(int j=0;j<=2;j++)
		{
			stepdetails[k]=Excel_Lib.getData(INPUT_PATH_1,"Stepdetail",i, j);
			k++;
		}
		}
		actual[7]=  ctc.enterTestCaseStepDetail(stepdetails);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^Test Case With Step Detail Field Should be Created$")
	public void test_Case_With_Step_Detail_Field_Should_be_Created() throws Throwable 
	{
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    log.info("Test Case Created With Test Steps");
	    
	    ctc.stepDetail.click();
	    bp.waitForElement();
	    tr.clickOnList();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
	

}
