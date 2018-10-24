package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Switch_TestCase_View_808870 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	NavigationPage np;
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	 String filename="Switch_TestCase_View_808870";
	@Given("^User is in the page testRepository page$")
	public void user_is_in_the_page_testRepository_page() throws Throwable {
		
		 try
		   {
			/* lb=new LaunchBrowser();
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
		   actual[2]= rp.clickOnTestRep(); 
		   }
		 catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}

	@Given("^User creates a phase under release$")
	public void user_creates_a_phase_under_release() throws Throwable {
		try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search", 2, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search", 2, 3);
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
	    }
		catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}

	@When("^User creates few testcases$")
	public void user_creates_few_testcases() throws Throwable {
		try
		{
			for(int i=0;i<=5;i++)
			{
			actual[6]=tr.addTestCase();
			}
		
		}
		catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}

	@When("^User navigates to the search view$")
	public void user_navigates_to_the_search_view() throws Throwable {
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		np=new NavigationPage(driver);
		bp.waitForElement();
		np.clickOnSearch.click();
		bp.waitForElement();
		actual[7]=tr.verifyPastTestCase();
		}
		catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}

	@When("^User navigates again to the folder view$")
	public void user_navigates_again_to_the_folder_view() throws Throwable {
		 try
		   {
			bp=new BasePage();
			bp.waitForElement();
			actual[8]=tr.clickedOnFolder();
			bp.waitForElement();
			actual[9]=tr.verifyPresentTestCase();
		   }
		 catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}

	@Then("^User successfully switch between between search and folder$")
	public void user_successfully_switch_between_between_search_and_folder() throws Throwable {
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	
		log.info("User successfully switch between between search and folder");
		
	}
		catch(Exception e)
		 {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		  e.printStackTrace();
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		 }
	}
}
