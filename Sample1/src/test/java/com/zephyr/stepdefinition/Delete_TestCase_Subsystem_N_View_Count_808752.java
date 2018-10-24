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

public class Delete_TestCase_Subsystem_N_View_Count_808752 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	String fileName="Delete_TestCase_Subsystem_N_View_Count_808752";
	
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the page TestRepository$")
	public void user_is_in_the_page_TestRepository() throws Throwable {
	    
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		  actual[2]= rp.clickOnTestRep();
		 // soft.assertAll();
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
	
	@Given("^Select a phase which contain subsystem$")
	public void select_a_phase_which_contain_subsystem() throws Throwable {
	    
		try
		{
			 tr=new TestRepositoryPage(driver);
		
				bp=new BasePage();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 0);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 3);
			
				bp.waitForElement();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				//bp.waitForElement();
				//bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				
				bp.waitForElement();
				
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 1);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 4);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				bp.waitForElement();
				actual[5]=tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				///bp.waitForElement();
				actual[6]=tr.navigateToNode(releaseName,phase );
				//bp.waitForElement();
				//bp.waitForElement();
				bp.waitForElement();
				actual[7]=tr.addNode(s_Name1,s_Desc1);
				bp.waitForElement();
				//tr.doubleClickOnRelease(releaseName);
				
				String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 2);
				String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 3, 5);
				String[] system= new String[2];
				system[0]=p_Name1;
				system[1]=s_Name1;
				bp.waitForElement();
				//bp.waitForElement();
				actual[8]=tr.doubleClickOnRelease(releaseName);
				//bp.waitForElement();
				bp.waitForElement();
				actual[9]=tr.navigateToNode(releaseName, system);
				bp.waitForElement();
				//bp.waitForElement();
				actual[10]=tr.addNode(ss_Name1,ss_Desc1);
				
				String[] subsystem= new String[3];
				subsystem[0]=p_Name1;
				subsystem[1]=s_Name1;
				subsystem[2]=ss_Name1;
				bp.waitForElement();
				//bp.waitForElement();
				actual[11]=tr.doubleClickOnRelease(releaseName);
				//bp.waitForElement();
				bp.waitForElement();
				actual[12]=tr.navigateToNode(releaseName, subsystem);
				bp.waitForElement();
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

	@When("^User creates few testcases in subsystem$")
	public void user_creates_few_testcases_in_subsystem() throws Throwable {
	    try
	    {
		for(int i=0;i<=6;i++)
		{
			actual[13]=tr.addTestCase();
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

	@When("^User delete a testcase and view the count$")
	public void user_delete_a_testcase_and_view_the_count() throws Throwable {
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String[] testCaseNo=new String[3];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		bp.waitForElement();
		ep=new ExportPage(driver);
	    actual[14]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
	    bp.waitForElement();
	    actual[15]=tr.deleteTestCase();
	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
	    //TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
		//tp.deleteMultipleTestCases.click();
		//bp.waitForElement();
		tr.testCaseCount();
		System.out.println(tr.testCaseCount());
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

	@Then("^User should display the correct count$")
	public void user_should_display_the_correct_count() throws Throwable {
	   
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     
		log.info("User should display the correct count successfully");
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
