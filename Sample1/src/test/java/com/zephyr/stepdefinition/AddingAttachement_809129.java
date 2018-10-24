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

public class AddingAttachement_809129 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
    boolean[] actual=new boolean[6];
	
	SoftAssert soft=new SoftAssert();

	String fileName="AddingAttachement_809129";
	
@Given("^Lead is in Test Case Details Page$")
public void lead_is_in_Test_Case_Details_Page() throws Throwable
{
//
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",2,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",2,1);
//	   
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
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
	    //String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String[] phases=new String[1];
		tr.doubleClickOnRelease(releaseName);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",4, 0);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",4, 0);
		tr.addNode(Name, Desc);
		tr.doubleClickOnRelease(releaseName);
		phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",4, 0);
		actual[3]=tr.navigateToNode(releaseName, phases);
	   Thread.sleep(4000);
	   ctc=new CreateTestCasePage(driver);
	   String[] name=new String[1];
	   name[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"TestCase",1,0);
	   actual[4]=tr.addTestCase();
	   actual[5]=tr.clickDetailButton();
	   
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
	   //ctc.selectTestCase(id);
	  // ctc.clickOnTestCaseDetail();
  
}

@When("^Lead click On Attachement and browse The File$")
public void lead_click_On_Attachement_and_browse_The_File() throws Throwable {
	
	try
	{
		String[] f=new String[1];
	//f[0]="C:\\Users\\RAJNEESH\\Desktop\\Autoscript.exe";
	//f[0]="./AutoscriptFile/Auto_Script_1.exe";
	f[0]=Excel_Lib.getData(INPUT_PATH_1,"File",2,0);
	actual[5]=ctc.uploadAttachement(f); 
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

@Then("^Selected File Should Be Attached To The Test Case$")
public void selected_File_Should_Be_Attached_To_The_Test_Case() throws Throwable {
    try
    {
    	tr.clickOnList();
    	
    	for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	 log.info("File Attached to the Test Case");
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
