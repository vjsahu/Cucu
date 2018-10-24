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

public class AddingTestCase_P_S_SS_808876 extends LaunchBrowser
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
	
	String fileName="AddingTestCase_P_S_SS_808876";
	
	@Given("^User is in the Test Repository Page$")
	public void user_is_in_the_Test_Repository_Page() throws Throwable {
		  
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
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   
		   pp=new ProjectPage(driver);
		   actual[0]=pp.selectProject(projectName);
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

	@When("^User Create a Phase$")
	public void user_Create_a_Phase() throws Throwable 
	{
		try
		{
	 tr=new TestRepositoryPage(driver);
    String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
    actual[3]=tr.doubleClickOnRelease(releaseName);
    
    //Creating Phase
    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",4,0);
    String pDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",4,1);
    actual[4]=tr.addNode(pName, pDesc);
    
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
	@When("^Add Test Case to the Phase$")
	public void add_Test_Case_to_the_Phase() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
	   
		
		//actual[5]=tr.clickDetailButton();
		//actual[6]=tr.addNewTestCaseInDetilview();
	    
		actual[5]=tr.addTestCase();
		//actual[7]=tr.moveToNodesInDetail();
		actual[6]= tr.doubleClickOnRelease(releaseName);
		
		//tr.moveToNodesInDetail();
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
	
	@Then("^Test Case Should be Created in Phase$")
	public void test_Case_Should_be_Created_in_Phase() throws Throwable 
	{
		try
		{
			actual[7]=tr.verifyPresentTestCase();
	    log.info("Test Case Created Sucessfully in Phase");
		}catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	}

	@When("^User Creates a System$")
	public void user_Creates_a_System() throws Throwable {
		
		try
		{
	    String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
	    
	    
	    //navigate Phase
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",4,0);
	    actual[8]=tr.navigateToNode(releaseName, phase); 
	    
	    //Creating System
	    
	    String sName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",5,0);
	    String sDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",5,1);
	    actual[9]=tr.addNode(sName, sDesc);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
//	    
//	    tr.doubleClickOnRelease(releaseName);
//	    //Navigating to system
//	    String[] system=new String[2];
//	    system[0]=Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",4,0);
//	    system[1]=Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",5,0);
//	    tr.navigateToNode(releaseName, system);
	}


@When("^Add Test Case to the System$")
public void add_Test_Case_to_the_System() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases", 1,0);
	 
	
//	actual[11]=tr.addNewTestCaseInDetilview();
//	 
//	actual[12]=tr.moveToNodesInDetail();
	tr.addTestCase();

	actual[10]=tr.doubleClickOnRelease(releaseName);
	
	//tr.moveToNodesInDetail();
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

@Then("^Test Case Should be Created in System$")
public void test_Case_Should_be_Created_in_System() throws Throwable {
  
	try
	{
		log.info("Test Case Successfully Created in System");
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

@When("^User Creates a Subsystem$")
public void user_Creates_a_Subsystem() throws Throwable {
	
	try
	{
		//Navigating to System
	String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
    String[] system=new String[2];
    
    system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",4, 0);
    system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",5, 0);
    
    actual[11]=tr.navigateToNode(releaseName,system);
   //Creating Subsystem
    String subName=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",6,0);
    String subDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Node_Creation",6,1);
    actual[12]=tr.addNode(subName, subDesc); 
    
    tr.doubleClickOnRelease(releaseName);
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
    
//    tr.doubleClickOnRelease(releaseName);
//    //Navigating to subsystem
//    String[] subsystem= new String[3];
//    subsystem[0]=Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",4, 0);
//    subsystem[1]=Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",5, 0);
//    subsystem[2]=Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",6, 0);
//    tr.navigateToNode(releaseName, subsystem);
}



@When("^Add Test Case to the Subsystem in Detail view$")
public void add_Test_Case_to_the_Subsystem_in_Detail_view() throws Throwable 
{
	try
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
	    String[] subsystem=new String[3];
	    
	    subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",4, 0);
	    subsystem[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",5, 0);
	    subsystem[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1, "Node_Creation",6, 0);
	    
	    actual[11]=tr.navigateToNode(releaseName,subsystem);
		actual[13]=tr.clickDetailButton();
		
		actual[14]=tr.addNewTestCaseInDetilview();
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

@Then("^Test case Should be created in Subsystem$")
public void test_case_Should_be_created_in_Subsystem() throws Throwable
{
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
   log.info("Test Case sucessfully Added in Subsystem");
   
   tr.clickOnList();
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
