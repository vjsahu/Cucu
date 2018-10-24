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

public class EditTestCase_809410 extends LaunchBrowser 
{
	//LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	
	boolean[] actual=new boolean[8];
	   SoftAssert soft=new SoftAssert();
	
	   LaunchBrowser lb=new LaunchBrowser();
		String fileName="EditTestCase_809410";
		
	@Given("^User is in the phase page$")
	public void user_is_in_the_phase_page() throws Throwable {
	    try
	    {
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		  
		   tr=new TestRepositoryPage(driver);
		  
		   tr.doubleClickOnRelease(releaseName);
		   String phase1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 8, 0);
		   String desc1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 8, 0);
		   tr.addNode(phase1, desc1);
		   
		  
		   bp.waitForElement();
		   bp.waitForElement();
		   tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 8, 0);
		   actual[3]=tr.navigateToNode(releaseName, phase);
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

	@When("^User add a test case and click on detail$")
	public void user_add_a_test_case_and_click_on_detail() throws Throwable 
	{
		try
		{
			 actual[4]=tr.addTestCase(); 
			 actual[5]=tr.clickDetailButton();
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	 
 
	 
	}

	@When("^enter multiple tags and save it$")
	public void enter_multiple_tags_and_save_it() throws Throwable {
	   
		try
		{
			bp=new BasePage();
		ctc=new CreateTestCasePage(driver);
	    String[] tags=new String[3];
	    tags[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 3);
	    tags[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 3);
	    tags[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 3, 3);
	    actual[6]=ctc.enterMultipleTags(tags);
	    bp.waitForElement();
	    
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

	@When("^edit the entered multiple test case and save it$")
	public void edit_the_entered_multiple_test_case_and_save_it() throws Throwable 
	{
		try
		{
		String[] newTags=new String[3];
		newTags[0]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 1, 3);
		newTags[1]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 2, 3);
		newTags[2]=Excel_Lib.getData(INPUT_PATH_2, "EditTestCase", 3, 3);
		 actual[7]=ctc.editTags(newTags);
		}
		catch(Exception e)
		{lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}

	@Then("^test case edited successfully$")
	public void test_case_edited_successfully() throws Throwable 
	{
		try
		{

		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	    log.info("Test case edited sucessfully");
	    
	    tr.clickOnList();
		}
	    catch(Exception e)
		{lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
		}
	}


}
