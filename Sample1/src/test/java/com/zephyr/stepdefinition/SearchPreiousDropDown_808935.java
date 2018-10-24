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

public class SearchPreiousDropDown_808935 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tp;
	NavigationPage np;
	BasePage bp;
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	 String filename="SearchPreiousDropDown_808935";
	@Given("^User is present the repositorypage$")
	public void user_is_present_the_repositorypage() throws Throwable 
	{
		try
		{
//		lb= new LaunchBrowser();
//		lb.preCond();
//		
//		 lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		 
			pp=new ProjectPage(driver);
		   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
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

	@When("^User clicks on search and Advance search$")
	public void user_clicks_on_search_and_Advance_search() throws Throwable
	{
		try
		{
			String searchId=Excel_Lib.getData(INPUT_PATH_4,"searchids", 6, 0);
			np=new NavigationPage(driver);
			actual[3]=np.searchAndAdd(searchId);	
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

	@When("^search with creator and click on previous search$")
	public void search_with_creator_and_click_on_previous_search() throws Throwable 
	{
		try
		{
			String searchId2=Excel_Lib.getData(INPUT_PATH_4,"searchids", 7, 0);
			String searchId1=Excel_Lib.getData(INPUT_PATH_4,"searchids",7,1);
			actual[4]=np.selectpreviousSearch(searchId2,searchId1);
			tp=new TestRepositoryPage(driver);
			bp=new BasePage();
			tp.clickedOnFolder();
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

	@Then("^Should able view in dropdown$")
	public void should_able_view_in_dropdown() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("elements are viewed in dropdown");
//		 pp=new ProjectPage(driver);
//		    pp.clickOnLogout();
//		    lb=new LaunchBrowser();
//		    lb.close();
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
