package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCaseWithExecutionTime_809290 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;

	boolean[] actual=new boolean[26];
	  SoftAssert soft=new SoftAssert();
	
	  String fileName="TestCaseWithExecutionTime_809290";
	  
			
	@Given("^Manager is in the Phase Page of Test Repository$")
	public void manager_is_in_the_Phase_Page_of_Test_Repository() throws Throwable 
	{
//		   
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",1,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",1,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		  
		try
		{
			lb=new LaunchBrowser();
		   pp=new ProjectPage(driver);
		   lp=new LoginPage(driver);
		   bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		   //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   tr.doubleClickOnRelease(releaseName);
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
		   tr.addNode(Name, Desc);
		   tr.doubleClickOnRelease(releaseName);
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
			actual[3]=tr.navigateToNode(releaseName, phases);
		   Thread.sleep(4000);
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		   
	    
	}

	@When("^Manager clicks On Add button$")
	public void manager_clicks_On_Add_button() throws Throwable 
	{
		try
		{
		actual[4]=tr.addTestCase();
		  
		  //ctc=new CreateTestCase(driver);
		  
		 // ctc.clickOnTestCaseDetail();
		actual[5]=tr.clickDetailButton();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		 
	}

	@When("^Enters Estimated Time$")
	public void enters_Estimated_Time() throws Throwable {
		try
		{
		String[] time=new String[3];
		int k=0;
		for(int i=0;i<=time.length-1;i++)
		{
			int l=Excel_Lib.getNumberData(INPUT_PATH_1,"Estimated_Time",1, i);
			time[k]=Integer.toString(l);
	        //time[k]=Double.toString(Excel_Lib.getNumberData(INPUT_PATH,"Estimated_Time",1, i));
	        k++;
		}
		 ctc=new CreateTestCasePage(driver);
		 actual[6]=ctc.enterEstimatedTime(time[0],time[1],time[2]);
		 bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^Logout from Zephyr Application$")
	public void logout_from_Zephyr_Application() throws Throwable
	{
		try
		{
		actual[7]=pp.clickOnLogout();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Given("^Lead is in the Phase Page of Test Repository$")
	public void lead_is_in_the_Phase_Page_of_Test_Repository() throws Throwable 
	{
		try
		{
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_1");
		   
		   actual[8]=lp.enterUname(Uname);
		   actual[9]=lp.enterPass(Pass);
		   actual[10]=lp.clickOnLogin();
		   bp.waitForElement();
		   
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[11]=pp.selectProject(projectName);
		   actual[12]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[13]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		    //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
			actual[14]=tr.navigateToNode(releaseName, phases);
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		   //Thread.sleep(4000);
	    
	}
	
	@When("^Lead clicks On Add button$")
	public void lead_clicks_On_Add_button() throws Throwable {
		try
		{
		actual[15]=tr.addTestCase();
		actual[16]=tr.clickDetailButton();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	   // ctc.clickOnTestCaseDetail();
	}
	@Given("^Tester is in the Phase Page of Test Repository$")
	public void tester_is_in_the_Phase_Page_of_Test_Repository() throws Throwable {
		try
		{
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Password_1");
		   
		   actual[17]=lp.enterUname(Uname);
		   actual[18]=lp.enterPass(Pass);
		   actual[19]=lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[20]=pp.selectProject(projectName);
		   actual[21]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[22]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		    //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		    String[] phases=new String[1];
		    phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
		    actual[23]=tr.navigateToNode(releaseName, phases);
		    
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		  // Thread.sleep(4000);
	}

	@When("^Tester clicks On Add button$")
	public void tester_clicks_On_Add_button() throws Throwable 
	{
		try
		{
			actual[24]=tr.addTestCase();
			actual[25]=tr.clickDetailButton();
			bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	    //ctc.clickOnTestCaseDetail();
	}

	@Then("^Test Case Created successfully with Estimated Time$")
	public void test_Case_Created_successfully_with_Estimated_Time() throws Throwable 
	{
		try
		{
			  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_1");
			   
			 actual[17]=lp.enterUname(Uname);
			   actual[18]=lp.enterPass(Pass);
			   actual[19]=lp.clickOnLogin();
			for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
		       
			   
			  
	    log.info("Test case created successfully with estimated Time");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}


	

	
}
