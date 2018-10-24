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
import cucumber.api.java.en.When;

public class AddingTestCase_808922 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;

	boolean[] actual=new boolean[15];
	SoftAssert soft=new SoftAssert();
	
	String fileName="AddingTestCase_808922";
	
	@Given("^User is in Test Repository Page$")
	public void user_is_in_Test_Repository_Page() throws Throwable 
	{
		 
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",2,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		 
		try
		{
			 lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   bp.waitForElement();
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
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

	@When("^User Creates a Phase and Navigate to Detail view$")
	public void user_Creates_a_Phase_and_Navigate_to_Detail_view() throws Throwable
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
		tr=new TestRepositoryPage(driver);
	   bp=new BasePage();
		 actual[3]=tr.doubleClickOnRelease(releaseName);
	    //Creating Phase
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",1,0);
	    String pDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",1,1);
	    actual[4]=tr.addNode(pName, pDesc);
	   bp.waitForElement();
	    actual[5]=tr.doubleClickOnRelease(releaseName);
	    
	    //Navigating to Phase
	    String[] phase1=new String[1];
	    phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",1,0);
	    actual[6]=tr.navigateToNode(releaseName,phase1); 
	    
	    actual[7]=tr.clickDetailButton();
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

	@When("^Add a test Case$")
	public void add_a_test_Case() throws Throwable 
	{
		try
		{
			 actual[8]=tr.addNewTestCaseInDetilview();
			 actual[9]=tr.clickOnList();
			 //actual[9]=tr.moveToNodesInDetail();
	     String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
	     actual[10]=tr.doubleClickOnRelease(releaseName);
	    // tr.moveToNodesInDetail();
	  // tr.addTestCase();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User creates a System and Navigate to Detail view$")
	public void user_creates_a_System_and_Navigate_to_Detail_view() throws Throwable 
	{  
		try
		{
		//Navigating to Phase
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",1, 0);
	    actual[11]=tr.navigateToNode(releaseName,phase);
	   
	    //Creating System
	    String sName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",2,0);
	    String sDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",2,1);
	    actual[12]=tr.addNode(sName, sDesc);
		
	    tr.doubleClickOnRelease(releaseName);
	    //Navigating to System
	    String[] system=new String[2];
	    system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",1,0);
	    system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",2, 0);
	    tr.navigateToNode(releaseName, system);
	    
	    tr.clickDetailButton();
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

	@When("^User Creates a Subsystem and Navigate to Detail view$")
	public void user_Creates_a_Subsystem_and_Navigate_to_Detail_view() throws Throwable {
		try
		{
		//Navigating to System
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
	    String[] system=new String[2];
	    system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",1, 0);
	    system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",2, 0);
	    actual[13]=tr.navigateToNode(releaseName,system);
	   
	    //Creating Subsystem
	    String subName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",3,0);
	    String subDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Test_808922",3,1);
	    actual[14]=tr.addNode(subName, subDesc); 
	    
	    tr.doubleClickOnRelease(releaseName);
	    //Navigating to subsystem
	    String[] subsystem= new String[3];
	    subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",1, 0);
	    subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",2, 0);
	    subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Test_808922",3, 0);
	    tr.navigateToNode(releaseName, subsystem);
	    
	    tr.clickDetailButton();
	
	    
	    for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
    	
    	//tr.clickOnList();
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
