package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingTags_809283 extends LaunchBrowser
{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	
	String fileName="AddingTags_809283";
	@Given("^User is in the Test case page$")
	public void user_is_in_the_Test_case_page() throws Throwable {
		 
//		 actual[0]=lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",3,1);
//		   actual[0]=lp.enterUname(Uname);
//		   actual[1]=lp.enterPass(Pass);
//		   actual[2]=lp.clickOnLogin();
		  
		try
		{
			lb=new LaunchBrowser();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   
		   tr=new TestRepositoryPage(driver);
		   
			//String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   tr.doubleClickOnRelease(releaseName);
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"File",6, 0);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"File",6, 0);
		   tr.addNode(Name, Desc);
		   tr.doubleClickOnRelease(releaseName);
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"File",6, 0);
			actual[3]=tr.navigateToNode(releaseName,phases);
			actual[4]=tr.addTestCase();
		
//			String[] name=new String[1];
//			name[0]=Excel_Lib.getData(INPUT_PATH_1,"File",6, 1);
//			actual[4]=tr.selectTestCase(name);
			actual[5]=tr.clickDetailButton();
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

	@When("^User Add tags to the test case$")
	public void user_Add_tags_to_the_test_case() throws Throwable
	{
		try
		{
		String[] tags=new String[3];
		tags[0]=Excel_Lib.getData(INPUT_PATH_1,"File",6, 2);
		tags[1]=Excel_Lib.getData(INPUT_PATH_1,"File",7, 2);
		tags[2]=Excel_Lib.getData(INPUT_PATH_1,"File",8, 2);
	    
		CreateTestCasePage ctc=new CreateTestCasePage(driver);
		
		actual[6]=ctc.enterMultipleTags(tags);
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

	@Then("^Tags successfully added to the test case$")
	public void tags_successfully_added_to_the_test_case() throws Throwable 
	{
		try
		{
	  
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
		log.info("Successfully Tags Added");
		
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
