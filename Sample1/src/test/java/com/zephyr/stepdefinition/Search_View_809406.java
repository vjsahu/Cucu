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

public class Search_View_809406 extends LaunchBrowser {
	
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
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	 String filename="Search_View_809406";
	@Given("^User is in a page Test Repository$")
	public void user_is_in_a_page_Test_Repository() throws Throwable {
		try
		{
			/*lb=new LaunchBrowser();
			   lb.preCond();
			   
			   lp=new LoginPage(driver);
			  
			   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
			   lp.enterUname(Uname);
			  // bp.waitForElement();
			   lp.enterPass(Pass);
			   lp.clickOnLogin();*/
			   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		  actual[0]= pp.selectProject(projectName);
		  bp.waitForElement();
		  actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   
		   
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

	@Given("^User creates a phase under a release$")
	public void user_creates_a_phase_under_a_release() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search", 1, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search", 1, 3);
		
		
		actual[3]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
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

	@When("^User adding a testcase under$")
	public void user_adding_a_testcase_under() throws Throwable {
	    
		actual[5]=tr.addTestCase();
		bp.waitForElement();
	}

	@When("^User adds a testcase$")
	public void user_adds_a_testcase() throws Throwable 
	{try
	{
		actual[6]=tr.addTestCase();
		bp.waitForElement();
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

	@Then("^User go to expand mode$")
	public void user_go_to_expand_mode() throws Throwable {
		try
		 {
			tr.clickOnDetailView.click();
			bp.waitForElement();
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

	@Then("^User navigates to a search view$")
	public void user_navigates_to_a_search_view() throws Throwable {
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			//tr.verifyPastTestCase();
			//bp.waitForElement();
			np=new NavigationPage(driver);
			bp.waitForElement();
			np.clickOnSearch.click();
			bp.waitForElement();
			actual[7]=tr.verifyPastTestCase();
			bp.waitForElement();
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

	@When("^User navigates a folder view$")
	public void user_navigates_a_folder_view() throws Throwable {
		try
		   {
				bp=new BasePage();
				bp.waitForElement();
				actual[8]=tr.clickedOnFolder();
				bp.waitForElement();
				tr.verifyPresentTestCase();
				bp.waitForElement();
				np.clickOnSearch.click();
//				tr.clickOnList();
				bp.waitForElement();
//				bp.waitForElement();
			tr.clickedOnFolder();
				bp.waitForElement();
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

	@Then("^User successfully navigating from search view to folder view$")
	public void user_successfully_navigating_from_search_view_to_folder_view() throws Throwable {
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	
		log.info("navigation from search view to folder view is done successfull");
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
