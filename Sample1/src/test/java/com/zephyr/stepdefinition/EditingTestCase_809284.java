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

public class EditingTestCase_809284 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditingTestCase_809284";

	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();

@Given("^Tester is in the test case Page$")
public void tester_is_in_the_test_case_Page() throws Throwable {
//	  lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",3,1);
//	   
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
	try
	{
		bp=new BasePage();
	   pp=new ProjectPage(driver);
	   
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	   tr=new TestRepositoryPage(driver);
	   
	   tr.doubleClickOnRelease(releaseName);
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809284",1,0);
	   String desc=Excel_Lib.getData(INPUT_PATH_1,"Test_809284",1,0);
	   tr.addNode(name, desc);
	   bp.waitForElement();
	   bp.waitForElement();
	   
	   tr.doubleClickOnRelease(releaseName);
	    //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String[] phases=new String[1];
		phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_809284",1, 0);
		actual[3]=tr.navigateToNode(releaseName, phases);
		bp.waitForElement();
	  // Thread.sleep(4000);
	   //ctc=new CreateTestCase(driver);
		
		actual[4]=tr.addTestCase();
		actual[5]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
	    String[] tags1=new String[2];
	    tags1[0]=Excel_Lib.getData(INPUT_PATH_1, "Tags", 1, 1);
	    tags1[1]=Excel_Lib.getData(INPUT_PATH_1, "Tags", 2, 1);
	   
	    actual[6]=ctc.enterMultipleTags(tags1);
	    bp.waitForElement();
		
		
	   //String[] name=new String[1];
	   //name[0]=Excel_Lib.getData(INPUT_PATH_1,"Test_809284",1,1);
	  // ctc.selectTestCase(name);
	  // ctc.clickOnTestCaseDetail();
	
	
	   
	   
	   //actual[4]=tr.selectTestCase(name);
	  // actual[5]=tr.clickDetailButton();
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^Tester Edit a tag of test case$")
public void tester_Edit_a_tag_of_test_case() throws Throwable 
{
	try
	{
    ctc=new CreateTestCasePage(driver);
    String[] tags=new String[1];
    tags[0]=Excel_Lib.getData(INPUT_PATH_1,"Test_809284",1, 2);
    actual[7]=ctc.editTags(tags);
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
	    e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@Then("^test case successfully edited$")
public void test_case_successfully_edited() throws Throwable 
{
	try
	{
		
		  for(int k=0;k<=actual.length-1;k++)
	  	     {
			  System.out.println(actual[k]);
	  	      soft.assertEquals(actual[k], true);
	  	     }
	  	     soft.assertAll();
  log.info("Successfully Test Case tags Edited");
  
     tr.clickOnList();
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

}
