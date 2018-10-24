package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindAndAdd_MultiZQL_808826 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	
	String fileName="FindAndAdd_MultiZQL_808826";
	
	@Given("^User is in Testrepository$")
	public void user_is_in_Testrepository() throws Throwable 
	{
		try
		{
//		
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
			lb=new LaunchBrowser();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]= pp.selectProject(projectName);
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

	@When("^User Navigates to Sub-Node$")
	public void user_Navigates_to_Sub_Node() throws Throwable
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 1);
		actual[4]=tr.addNode(Name, Desc);
		actual[5]=tr.doubleClickOnRelease(releaseName);
		String add[]=new String[1];
		add[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		actual[6]=tr.navigateToNode(releaseName, add);
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

	@When("^User Performs FindAndAdd Operation Using Multiple ZQL terms$")
	public void user_Performs_FindAndAdd_Operation_Using_Multiple_ZQL_terms() throws Throwable 
	{
		try
		{
		
		String[] operator=new String[2];
		String[] symbol=new String[2];
		String[] value=new String[2];
		operator[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 0);
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 1);
		value[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 2);
		operator[1]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 2, 0);
		symbol[1]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 2, 1);
		value[1]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 4, 2);
		String colName=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 3);
		int colNum=Excel_Lib.getNumberData(INPUT_PATH, "FindAndAdd", 1, 4);
		String role=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 5);
		String selectCount=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 6);
		tr.findAndAdd(operator, symbol, value, colName, colNum, role, selectCount);
	  // tr.findAndAdd("creator","=", "\"test.lead\"", "createdBy", "11","Test Lead","Single");
		
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

	@Then("^TestCases should be Added Successfully with multiple ZQL$")
	public void testcases_should_be_Added_Successfully_with_multiple_ZQL() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
			  {
		    	soft.assertEquals(actual[k], true);
		       }
	    	soft.assertAll();
	    log.info("Pass - TestCases should be Added Successfully with multiple ZQL");
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
