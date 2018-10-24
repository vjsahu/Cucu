package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
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

public class SearchTestcaseWithQuery_808868 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	String id;
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	 String filename="SearchTestcaseWithQuery_808868";
	@Given("^User in repository page to search ZQl query$")
	public void user_in_repository_page_to_search_ZQl_query() throws Throwable 
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
	   System.out.println(projectName);
	   System.out.println(releaseName);
	   actual[0]=pp.selectProject(projectName);
	   bp.waitForElement();
	   actual[1]=pp.selectRelease(releaseName);
	   bp.waitForElement();
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	   bp.waitForElement();
	   
	   tr=new TestRepositoryPage(driver);
	   String name=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails",7,0);
	   String desc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails",7,1);
			   
	 String[] node=new String[1];
	 node[0]=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails",7,0);
	   tr.clickOnRelease(releaseName);
	   tr.addNode(name, desc);
	   tr.navigateToNode(releaseName, node);
	   
	   tr.addTestCase();
	   
	  id= driver.findElement(By.xpath("//*[@id='grid-table-tcr']/div[2]/div[1]/div[3]/div/div")).getText();
	  
	  //Excel_Lib.setData(INPUT_PATH_4, "searchids", 12, 0, id);
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
	@When("^User click on search button$")
	public void user_click_on_search_button() throws Throwable 
	{
		try
		{
		String searchIdOperator=Excel_Lib.getData(INPUT_PATH_4,"searchids", 1, 0);
		String searchId=searchIdOperator+id;
		np=new NavigationPage(driver);
//		String r="creator=";
//		String p= "\"" + "test.lead" + "\"";
//		String x=r+p;
		actual[3]=np.searchAndAdd(searchId);
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
	@When("^Select advanced search with query$")
	public void select_advanced_search_with_query() throws Throwable 
	{
		try
		{
//			String searchIdOperator=Excel_Lib.getData(INPUT_PATH_4,"searchids", 1, 0);
//			String searchId=searchIdOperator+id;
		String searchId=Excel_Lib.getData(INPUT_PATH_4,"searchids", 1, 0);
		String searchId1=id;
		//String p= "\"" + "test.lead" + "\"";
		actual[4]=np.selectpreviousSearch(searchId,searchId1);
		bp.waitForElement();
		//List<WebElement> all=driver.findElements(By.xpath(".//*[@id='grid-table-tcr']/div[2]/div/div[3]/div/div"));
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

	@Then("^hould display all the matching test cases$")
	public void hould_display_all_the_matching_test_cases() throws Throwable
	{
		try
		{
			tr.clickOnFolder();
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	   log.info("test cases are displayed");
//	   bp=new BasePage();
//	   bp.waitForElement();
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
