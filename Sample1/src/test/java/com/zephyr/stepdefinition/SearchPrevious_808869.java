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

public class SearchPrevious_808869 extends LaunchBrowser 
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
	 String filename="SearchPrevious_808869";
	@Given("^User is preseent in the reposirory page$")
	public void user_is_preseent_in_the_reposirory_page() throws Throwable 
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
	   pp=new ProjectPage(driver);
	   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	  // tr=new TestRepositoryPage(driver);
	   //tr.doubleClickOnRelease(releaseName);
	   
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
	  
		}
		catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}
	@When("^Click on  the Search and Advance search$")
	public void click_on_the_Search_and_Advance_search() throws Throwable 
	{
		try
		{
			String searchIdOperator=Excel_Lib.getData(INPUT_PATH_4,"searchids", 1, 0);
			String searchID=id;
			String searchId=searchIdOperator+searchID;
		np=new NavigationPage(driver);
//		String r="creator=";
//		String p= "\"" + "test.lead" + "\"";
//		String x=r+p;
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
	@When("^Click on search and pass data$")
	public void click_on_search_and_pass_data() throws Throwable
	{
		try
		{
		String searchId=Excel_Lib.getData(INPUT_PATH_4,"searchids", 1, 0);
		String searchId1=id;
		//String p= "\"" + "test.lead" + "\"";
		actual[4]=np.selectpreviousSearch(searchId,searchId1);
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

	@When("^Click on previous search select previous data$")
	public void click_on_previous_search_select_previous_data() throws Throwable
	{
		try
		{
	  //np.selectpreviousSearch(value);
//		System.out.println(all.size());
//		System.out.println(all.get(0).getText());
//		System.out.println(all.get(1).getText());
//		System.out.println(all.get(2).getText());
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

	@Then("^Should match with previous results$")
	public void should_match_with_previous_results() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("elements matched sucessfully");
//		bp=new BasePage();
//		   bp.waitForElement();
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
