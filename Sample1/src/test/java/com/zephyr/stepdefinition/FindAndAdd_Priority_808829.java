package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindAndAdd_Priority_808829 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	
	String fileName="FindAndAdd_DetailView_809375";
	
	@Given("^User is in the TestRepositorypage$")
	public void user_is_in_the_TestRepositorypage() throws Throwable
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
//		   
			lb=new LaunchBrowser();
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

	@When("^User Navigates upto Sub-Folder levels$")
	public void user_Navigates_upto_Sub_Folder_levels() throws Throwable 
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
		 
		 
		 actual[7]=tr.addTestCase();
		 
		 actual[8]=tr.clickDetailButton();
		 
		 //ctc=new CreateTestCasePage(driver);
		 
		    ctc=new CreateTestCasePage(driver);
			String details[]=new String[4];
			details[0]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",1,4);
			//System.out.println( details[0]);
			details[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH,"Modify_TC",99,99));
			//System.out.println(details[1]);
			details[2]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",99,99);
			details[3]=Excel_Lib.getData(INPUT_PATH,"Modify_TC",99,99);
			actual[9]=ctc.enterTestCaseDetail(details);
			
			actual[10]=tr.clickOnList();
		// ctc.enterTestCaseDetail(details);
		 
			 actual[5]=tr.doubleClickOnRelease(releaseName);
				String add1[]=new String[1];
				add1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
				 actual[11]=tr.navigateToNode(releaseName, add1);
				 
		 
		 
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

	@When("^User Performs FindAndAdd Operation using ZQL with in Operator$")
	public void user_Performs_FindAndAdd_Operation_using_ZQL_with_in_Operator() throws Throwable 
	{
		try
		{
		String[] operator=new String[1];
		String[] symbol=new String[1];
		String[] value=new String[1];
		operator[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 4, 0);
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 4, 1);
		value[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 6, 2);
		String colName=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 100, 100);
		int colNum=Excel_Lib.getNumberData(INPUT_PATH, "FindAndAdd", 100, 100);
		String role=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 5);
		String selectCount=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 6);
          tr.findAndAdd(operator, symbol, value, colName, colNum, role, selectCount);
	  // tr.findAndAdd("creator","=", "\"test.lead\"", "createdBy", "11","Test Lead","Single");
		// WebElement inst=driver.findElement(By.xpath("//*[@id='find-and-add-modal']/div/div/div[1]/div[2]/button"));
		  
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

	@Then("^TestCases Should be added Successfully$")
	public void testcases_Should_be_added_Successfully() throws Throwable 
	{
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
			  {
		    	soft.assertEquals(actual[k], true);
		       }
	    	soft.assertAll();
		log.info("Pass - TestCases are Added Successfully with Priority Operator");
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
