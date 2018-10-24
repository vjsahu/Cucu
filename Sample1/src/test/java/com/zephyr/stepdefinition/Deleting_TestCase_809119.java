package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Deleting_TestCase_809119 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	String fileName="Deleting_TestCase_809119";
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Test Repository page$")
	public void user_is_in_Test_Repository_page() throws Throwable {
	    
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
			String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
			lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		  actual[2]= rp.clickOnTestRep(); 
		  //soft.assertAll();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Given("^User navigates to a node having test cases$")
	public void user_navigates_to_a_node_having_test_cases() throws Throwable {
	    
		try
		{
			tr=new TestRepositoryPage(driver);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 3);
			
				
				actual[3]=tr.doubleClickOnRelease(releaseName);
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp=new BasePage();
				bp.waitForElement();
				
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 1);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 4);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
//				bp.waitForElement();
//				bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName,phase );
				//bp.waitForElement();
				bp.waitForElement();
				actual[7]=tr.addNode(s_Name1,s_Desc1);
				
				String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 2);
				String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 1, 5);
				String[] system= new String[2];
				system[0]=p_Name1;
				system[1]=s_Name1;
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
//				bp.waitForElement();
//				bp.waitForElement();
				actual[9]=tr.navigateToNode(releaseName, system);
				actual[10]=tr.addNode(ss_Name1,ss_Desc1);
				
				for(int i=0;i<=2;i++)
				{
					actual[11]=tr.addTestCase();
				}
	 	
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
	
	@When("^User select test case and clicks on delete$")
	public void user_select_test_case_and_clicks_on_delete() throws Throwable {
	 
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String[] testCaseNo=new String[1];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	   
		bp.waitForElement();
		ep=new ExportPage(driver);
	    actual[12]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tr.deleteTestCase();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User should get a confirmation box with options \\[Yes\\] or \\[No\\]$")
	public void user_should_get_a_confirmation_box_with_options_Yes_or_No() throws Throwable {
	   try
	   {
//		bp=new BasePage();
//		bp.waitForElement();
//	  bp.waitForElement();
//	  bp.waitForElement();
		//TestRepositoryPage_POM  tp=new TestRepositoryPage_POM(driver);
		   log.info("Yes Option selected");
		//tp.deleteTestCaseMsg.click();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		   e.printStackTrace();
		   driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^User delete a test case successfully$")
	public void user_delete_a_test_case_successfully() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
	    		System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("test case deleted sucessfully");
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    	driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}
}
