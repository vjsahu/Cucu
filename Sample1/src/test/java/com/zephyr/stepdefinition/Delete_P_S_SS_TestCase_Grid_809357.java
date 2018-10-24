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

public class Delete_P_S_SS_TestCase_Grid_809357 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	ExportPage ep;
	String fileName="Delete_P_S_SS_TestCase_Grid_809357";
	
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Test Repository$")
	public void user_is_in_the_Test_Repository() throws Throwable {
	    

//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,0);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
	
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
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

	@Given("^User navigates to a subsystem containing test cases$")
	public void user_navigates_to_a_subsystem_containing_test_cases() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 3);
			
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			bp=new BasePage();
			bp.waitForElement();
			
			
			String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 1);
			String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 4);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName,phase );
			//bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=tr.addNode(s_Name1,s_Desc1);
			
			//tr.doubleClickOnRelease(releaseName);
			
			String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 2);
			String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 5);
			String[] system= new String[2];
			system[0]=p_Name1;
			system[1]=s_Name1;
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			//bp.waitForElement();
			actual[9]=tr.navigateToNode(releaseName, system);
			bp.waitForElement();
			//bp.waitForElement();
			actual[10]=tr.addNode(ss_Name1,ss_Desc1);
			bp.waitForElement();
			//bp.waitForElement();
			actual[11]=tr.addTestCase();
			actual[12]=tr.addTestCase();
			actual[13]=tr.addTestCase();
			//bp.waitForElement();
			//tr.doubleClickOnRelease(releaseName);

	 	actual[14]=tr.verifyPastTestCase();
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

	@When("^User deletes a subsystem which contains test cases$")
	public void user_deletes_a_subsystem_which_contains_test_cases() throws Throwable {
	    try
	    {
	    	
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	    	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 0);
	    	String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 1);
	    	String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Delete", 6, 2);
	    	String[] str=new String[3];
	    	str[0]=p_Name1;
	    	str[1]=s_Name1;
	    	str[2]=ss_Name1;
	    	bp.waitForElement();
	    	tr.doubleClickOnRelease(releaseName);
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	tr.navigateToNode(releaseName, str);
	    	bp.waitForElement();
	    	//bp.waitForElement();
	    	actual[15]=tr.deleteNode();
	    	actual[16]=tr.verifyPresentTestCase();
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
	
	@Then("^User deleted subsystem succesfully and no test case should present in the grid$")
	public void user_deleted_subsystem_succesfully_and_no_test_case_should_present_in_the_grid() throws Throwable {
	 try
	 {
		 for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("Subsystem containing test cases in the grid which should be deleted successfully");
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
