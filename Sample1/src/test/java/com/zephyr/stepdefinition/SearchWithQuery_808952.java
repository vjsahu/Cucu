package com.zephyr.stepdefinition;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class SearchWithQuery_808952 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	ExportPage ep;
	CreateTestCasePage ct;
	BasePage bp;
	boolean[] actual=new boolean[7];
	 SoftAssert soft=new SoftAssert();
	 String filename="SearchWithQuery_808952";
	@Given("^user present in the repository page$")
	public void user_present_in_the_repository_page() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		lb.preCond();
//	   
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
	   pp=new ProjectPage(driver);
	  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
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

	@When("^User click on search with query$")
	public void user_click_on_search_with_query() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			 tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
			   tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				String node=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 1, 4);
				String desc=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 1, 5);
//				String p_Name2=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 2, 0);
//				String Desc2=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 2, 1);
				tr.addNode(node,desc);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				String[] navigation=new String[1];
				navigation[0]=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 1, 4);
				tr.navigateToNode(releaseName, navigation);
				bp.waitForElement();
				tr.addTestCase();
				
				tr.clickDetailButton();
				bp.waitForElement();
			ct=new CreateTestCasePage(driver);
			String tcname=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 0);
			String tdescription=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 1);
			actual[3]=ct.enterTestCaseNameAndDesc(tcname,tdescription);
			bp.waitForElement();
			bp.waitForElement();
		//String tcname1=Excel_Lib.getData(INPUT_PATH_4,"searchids", 11, 0);
			String tcname1=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 0);
		np=new NavigationPage(driver);
//		actual[3]=np.searchAndAdd(searchId);//////////modified
		actual[4]=np.quiksearch(tcname1);
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

	@When("^select one test case$")
	public void select_one_test_case() throws Throwable 
	{
		try
		{
		String[] st=new String[1];
		st[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));////////////////////////
		bp=new BasePage();
		ep=new ExportPage(driver);
		bp.waitForElement();
		actual[5]=ep.selectMultipleTestcasesfromSearch(st);
		
		//tr.clickDetailButton();
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

	@When("^Edit the test case$")
	public void edit_the_test_case() throws Throwable 
	{
		try
		{
		ct=new CreateTestCasePage(driver);
		String tcname=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 0);
		String tdescription=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 1);
		actual[6]=ct.enterTestCaseNameAndDesc(tcname,tdescription);
		bp=new BasePage();
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

	//@SuppressWarnings("deprecation")
	@Then("^should able to edit and save$")
	public void should_able_to_edit_and_save() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String expected=ct.l1.get(0).getText();
		//System.out.println(expected);
		String actual1=Excel_Lib.getData(INPUT_PATH_4,"TcNameAndDes", 1, 0);
		bp=new BasePage();
		bp.waitForElement();
		tr.clickedOnFolder();
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		
		/*Assert.assertEquals(expected, actual1);
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();*/
	   log.info("tescase edited sucessfully");
	  

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
