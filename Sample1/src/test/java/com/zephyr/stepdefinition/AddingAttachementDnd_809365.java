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

public class AddingAttachementDnd_809365 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	 
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	
	String fileName="AddingAttachementDnd_809365";
	
	@Given("^Tester is in Test Case Detail Page$")
	public void tester_is_in_Test_Case_Detail_Page() throws Throwable
	{
		
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",3,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",3,1);
//		   
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		  
		try
		{
			lb=new LaunchBrowser();
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   tr=new TestRepositoryPage(driver);
		 
		   tr.doubleClickOnRelease(releaseName);
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"TestCase",2, 1);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"TestCase",2, 1);	   
		   tr.addNode(Name, Desc);
		   tr.doubleClickOnRelease(releaseName);
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"TestCase",2, 1);
			 actual[3]=tr.navigateToNode(releaseName, phases);
		     bp=new BasePage();
		     bp.waitForElement();
		   
		     actual[4]=tr.addTestCase();
		     actual[5]=tr.clickDetailButton();
		      //String[] name=new String[1];
			  //name[0]=Excel_Lib.getData(INPUT_PATH_1,"TestCase",2,0);
		  // ctc.selectTestCase(name);
		  // ctc.clickOnTestCaseDetail();
			  //actual[4]=tr.selectTestCase(name);
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		   //tr.clickDetailButton();
	}

	@When("^Tester Navigates to Attachement and Drag and Drop the File$")
	public void tester_Navigates_to_Attachement_and_Drag_and_Drop_the_File() throws Throwable {
		
		try
		{
			ctc=new CreateTestCasePage(driver);
		
		String[] f=new String[1];
		//f[0]="C:\\Users\\RAJNEESH\\Desktop\\Autoscript.exe";
		//f[0]=Excel_Lib.getData(INPUT_PATH,"File",1,0);
		f[0]=Excel_Lib.getData(INPUT_PATH_1,"File",2,0);
		 actual[6]=ctc.uploadAttachement(f); 
	    BasePage bp=new BasePage();
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

	@Then("^File should be Added To the Test Case$")
	public void file_should_be_Added_To_the_Test_Case() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	      log.info("File Successfully Uploaded to the Test Case");
	      
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
