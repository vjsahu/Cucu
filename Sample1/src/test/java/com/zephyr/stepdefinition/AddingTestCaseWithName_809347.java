package com.zephyr.stepdefinition;

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

public class AddingTestCaseWithName_809347 extends LaunchBrowser
{
	//LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	String fileName="AddingTags_809275";
	LaunchBrowser lb=new LaunchBrowser();
	
	@Given("^Lead or Manager is in the TestRepository Page$")
	public void lead_or_Manager_is_in_the_TestRepository_Page() throws Throwable {

//		   lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",2,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		  
		try
		{
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",2,0);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=  rp.clickOnTestRep();
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

	@When("^User Creates a Phase$")
	public void user_Creates_a_Phase() throws Throwable {
		
		try
		{
			tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 2,0);
	    tr.clickOnRelease(releaseName);
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809347",1,0);
	    String pDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809347",1,1);
	    
	    actual[3]= tr.addNode(pName, pDesc);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809347", 1, 0);
	    actual[4]= tr.doubleClickOnRelease(releaseName);
	    actual[5]= tr.navigateToNode(releaseName,phase);
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
	
	

@When("^Add a Test Case with name having max character$")
public void add_a_Test_Case_with_name_having_max_character() throws Throwable
{
	//tr.addTestCase();
	try
	{
		actual[6]= tr.addNewTestCaseInDetilview();
		actual[7]= tr.clickDetailButton();
    
    String testName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809347", 1, 2);
    String testDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809347", 2, 1);
    System.out.println(testDesc);
    ctc=new CreateTestCasePage(driver);
    actual[8]= ctc.enterTestCaseNameAndDesc(testName, testDesc);
	}
	catch(Exception e)
	{	lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@Then("^Test case should be added with Name$")
public void test_case_should_be_added_with_Name() throws Throwable 
{
	 //String testName=Excel_Lib.getData(INPUT_PATH_1,"Test_809347", 1, 2);
	 //String testDesc=Excel_Lib.getData(INPUT_PATH_1,"Test_809347", 10, 2);
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
   
    	log.info("Test Case Successfully Added with Name");
    	tr.clickOnList();
	}
	catch(Exception e)
	{	lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	}
	

}
