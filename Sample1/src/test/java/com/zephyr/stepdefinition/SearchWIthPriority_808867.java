package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchWIthPriority_808867 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	 String filename="SearchWIthPriority_808867";
	@Given("^user in the repository page to search$")
	public void user_in_the_repository_page_to_search() throws Throwable 
	{
		try
		{
	//		lb=new LaunchBrowser();
	//		lb.preCond();
	//	   lp=new LoginPage(driver);
	//	   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
	//	   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
	//	   lp.enterUname(Uname);
	//	   lp.enterPass(Pass);
	//	   lp.clickOnLogin();
			 bp=new BasePage();
			  
		   pp=new ProjectPage(driver);
		  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}
	@When("^user click on the search$")
	public void user_click_on_the_search() throws Throwable 
	{
		try
		{
			String priority=Excel_Lib.getData(INPUT_PATH_4,"priority",1,0);
		   np=new NavigationPage(driver);
		   actual[3]=np.quiksearch(priority);
		   bp=new BasePage();
		   bp.waitForElement();
		   bp.waitForElement();
		   String[] sortName=new String[1];
			sortName[0]="Priority";
			np.sortInSearchResult(sortName);
			bp.waitForElement();
		   
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}  
	}

	@When("^In quick search pass ZQL$")
	public void in_quick_search_pass_ZQL() throws Throwable 
	{
		try
		{
		String priority1=Excel_Lib.getData(INPUT_PATH_4,"priority",1,0);
		actual[4]=np.verifySearchResult(priority1);
		 bp=new BasePage();
		   bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   tr.clickedOnFolder();
		   bp.waitForElement();
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}
	@Then("^Should display All the testcases are matching$")
	public void should_display_All_the_testcases_are_matching() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	   log.info("elements are matching correctly");
//	   pp=new ProjectPage(driver);
//	    pp.clickOnLogout();
//	    lb=new LaunchBrowser();
//	    lb.close();
		}catch (Exception e) 
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
