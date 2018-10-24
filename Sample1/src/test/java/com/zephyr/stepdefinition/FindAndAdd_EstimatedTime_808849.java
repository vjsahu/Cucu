package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindAndAdd_EstimatedTime_808849 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	BasePage bp;
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	String fileName="FindAndAdd_EstimatedTime_808849";
	
	@Given("^User is in the Testrepositorypage$")
	public void user_is_in_the_Testrepositorypage() throws Throwable 
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
			bp=new BasePage();
		   ip=new ImportPage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
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

	@When("^User Navigates to Sub-folders Level$")
	public void user_Navigates_to_Sub_folders_Level() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 1);
		 actual[4]=tr.addNode(Name, Desc);
		 bp.waitForElement();
		 actual[5]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		String add[]=new String[1];
		add[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		 actual[6]=tr.navigateToNode(releaseName, add);
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

	@When("^User Performs FindAndAdd Operation using ZQL with estimatedtime$")
	public void user_Performs_FindAndAdd_Operation_using_ZQL_with_estimatedtime() throws Throwable 
	{
		try
		{
		
		String[] operator=new String[1];
		String[] symbol=new String[1];
		String[] value=new String[1];
		operator[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 7, 0);
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 1);
		value[0]="00:00:10";
		String colName=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 7, 3);
		int colNum=Excel_Lib.getNumberData(INPUT_PATH, "FindAndAdd", 7, 4);
		String role=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 5);
		String selectCount=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 6);
		 tr.findAndAdd(operator, symbol, value, colName, colNum, role, selectCount);
	  // tr.findAndAdd("creator","=", "\"test.lead\"", "createdBy", "11","Test Lead","Single");
		boolean stat=ip.closeInstruction.isDisplayed();
		if(stat==true)
		{
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			ip.closeInstruction.click();
		}
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

	@Then("^TestCases should be Added Successfully with estimatedtime$")
	public void testcases_should_be_Added_Successfully_with_estimatedtime() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		
	       {
	    	soft.assertEquals(actual[k], true);
	       }
    	soft.assertAll();
		
		log.info("Pass - TestCases are Added Successfully with estimatedtime Operator");
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
