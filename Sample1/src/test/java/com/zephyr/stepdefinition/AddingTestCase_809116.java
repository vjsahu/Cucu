package com.zephyr.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AddingTestCase_809116 extends LaunchBrowser
{
    //WebDriver driver;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	//boolean[] exp=new boolean[3];
	
	String fileName="AddingTestCase_809116";
	
	@Given("^Lead is in Test Repository Page$")
	public void lead_is_in_Test_Repository_Page() throws Throwable {
		   
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
		   bp=new BasePage();
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		  
		   //Assert.assertArrayEquals(status, actual);
		   tr=new TestRepositoryPage(driver);

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

	@When("^lead selects the phase$")
	public void lead_selects_the_phase() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);	   
		   tr.addNode(Name, Desc);
		   bp.waitForElement();
		   tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		String[] phases=new String[1];
		phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);
		//tr.doubleClickOnRelease(releaseName);
		actual[3]=tr.navigateToNode(releaseName,phases);
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
		
	
	@When("^clicks On Add button$")
	public void clicks_On_Add_button() throws Throwable {
	   try
	   {
	    
		   actual[4]=tr.verifyPastTestCase();
		   bp.waitForElement();
		   actual[5]=tr.addTestCase();
	   }
	   catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	    
//	    catch(Exception e)
//	    {
//	   
//	    	driver.close();
//	    	Login l=new Login();
//	    	l.user_Selects_the_Browser_Launches_it_and_Maximises_it();
//	    	l.user_Navigates_to_the_URL_provided();
//	    	l.user_Enters_Username_Password_and_clicks_on_login();
//	    	
//	    	e.printStackTrace();
//	    	throw e;
//	    }
	    
	}

	@Then("^new Test Case Should be Added to the Phase$")
	public void new_Test_Case_Should_be_Added_to_the_Phase() throws Throwable {
		try
		{
		actual[6]=tr.verifyPresentTestCase();
		bp.waitForElement();
		if(actual[5]==true)
		{
	    log.info("Test case added to the Phase");
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

	@When("^lead selects The System$")
	public void lead_selects_The_System() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);
			actual[7]=tr.navigateToNode(releaseName,phases);
			bp.waitForElement();
			  String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 1);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 1);	   
			   tr.addNode(Name, Desc);
			   bp.waitForElement();
			   tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		String[] systems=new String[2];
		systems[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);  
		systems[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 1);
		actual[8]=tr.navigateToNode(releaseName,systems);
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
	@Then("^new Test Case Should be Added to the System$")
	public void new_Test_Case_Should_be_Added_to_the_System() throws Throwable
	{
		try
		{
		actual[9]=tr.verifyPresentTestCase();
		bp.waitForElement();
	    log.info("Test Case Added to the system");
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	   // actual[1]= tr.addTestCase();
	}

	
	
	@When("^lead selects The Subsystem$")
	public void lead_selects_The_Subsystem() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		tr.doubleClickOnRelease(releaseName);	
		bp.waitForElement();
		String[] systems=new String[2];
		systems[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 0);  
		systems[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 1);
		actual[10]=tr.navigateToNode(releaseName,systems);
		bp.waitForElement();
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 2);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5, 2);	   
	   tr.addNode(Name, Desc);
	   bp.waitForElement();
	   tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
		String[] subsystems=new String[3];
		subsystems[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5,0);  
		subsystems[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5,1);
		subsystems[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",5,2);  
		actual[11]=tr.navigateToNode(releaseName, subsystems);
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

	@Then("^new Test Case Should be Added to the Subsystem$")
	public void new_Test_Case_Should_be_Added_to_the_Subsystem() throws Throwable {
		   try
		   {
			   actual[12]=tr.verifyPresentTestCase();
		   
		   for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    	
		   log.info("Test case added to the Subsystem");
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

	
	

