package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809172 extends LaunchBrowser 
{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	CreateTestCasePage ctc;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809172";
	
	
	
	@Given("^User is on the phase page \"([^\"]*)\"$")
	public void user_is_on_the_phase_page(String user) throws Throwable
	{
		try
		{
		  String Uname;
		 // String Pass;
		   bp=new BasePage();
		  if(user.equals("leadOne"))
		  {
		   lb=new LaunchBrowser();
		   lb.preCond();
		 
		  
		
		   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
		    lb.getUrl(url);
		    
		    Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_1");
		    
		  }
		  
		   
		   
		   else if(user.equals("lead"))
		   
		   {
			     Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_1");
			     
//		      Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",1,0);
//		      Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",1,1);
		   }
		   else if(user.equals("lead"))
		   {
			   Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_1");
			    //Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",2,0);
			    //Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",2,1);
		   }
		   else
		   {
			   Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Tester_Username_1");
//			    Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//			    Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);   
		   }
		  
		  lp=new LoginPage(driver);
		   lp.enterUname(Uname);
		   lp.enterPass(Uname);
		   lp.clickOnLogin();
		   
		   bp.waitForElement();
		   bp.waitForElement();
		   
		   pp=new ProjectPage(driver);
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();
		   
		   bp.waitForElement();
		   bp.waitForElement();
		   
		   
		   tr=new TestRepositoryPage(driver);
		   
//		   tr.doubleClickOnRelease(releaseName);
//		   String name=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 19, 0);
//		   String desc=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 19, 0);
//		   tr.addNode(name, desc);
		   
//		   bp.waitForElement();
//		   bp.waitForElement();
		   // tr.doubleClickOnRelease(releaseName);
		    bp.waitForElement();
		   String[] phase=new String[1];
		   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 19, 0);
		   tr.navigateToNode(releaseName, phase);
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

	@When("^User select the test cases$")
	public void user_select_the_test_cases() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		   ep=new ExportPage(driver);
		   String[] testCase=new String[3];
		   for(int i=0;i<=testCase.length-1;i++)
		   {
		   testCase[i]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestCaseNo", i+2, 0));
		   }
		   ep.selectMultipleTestCaseFromGrid(testCase);
		   bp.waitForElement();
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

	@When("^edit the AltId \"([^\"]*)\" of the multi-selected test cases$")
	public void edit_the_AltId_of_the_multi_selected_test_cases(String AltId) throws Throwable 
	{
		try
		{
			tr.editTestCase();
			bp.waitForElement();
		String[] altId=new String[3];
	    altId[0] =AltId;
	    altId[1]="";
	    altId[2]="";
	    String[] auto=new String[1];
	    auto[0]="";
	    ctc=new CreateTestCasePage(driver);
	    
	    
	    ctc.editMultipleTestCase(altId, auto);
	    ctc.saveMultipleTestCaseEdit();
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

	@Then("^AltId should be changed$")
	public void altid_should_be_changed() throws Throwable 
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
	   log.info("Alt Id Modified");
	   bp.waitForElement();
	   pp.clickOnLogout();
	   bp.waitForElement();
	  
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
}
