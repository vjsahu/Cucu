package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Page_Navigation_Between_Pages_809417 extends LaunchBrowser {

	//private static final String addTestCase = null;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	NavigationPage np;
	String fileName="Page_Navigation_Between_Pages_809417";
	
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in the page of the Test Repository$")
	public void user_is_in_the_page_of_the_Test_Repository() throws Throwable {
	 

		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		   //String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
	try
	{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
	}
	catch(Exception e)
	 {
		lb=new LaunchBrowser();
		lb.getScreenShot(fileName);	
		e.printStackTrace();
	 driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	  throw e;
	 }
	}

	@When("^User Creates a Phase,System and Subsystem and creates Fifty testcases$")
	public void user_Creates_a_Phase_System_and_Subsystem_and_creates_Fifty_testcases() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 6, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 6, 3);
		
		 
		 actual[3]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
		 actual[4]=tr.addNode(p_Name1,p_Desc1);
		
		String[] phase=new String[1];
		phase[0]=p_Name1;
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 6, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 6, 4);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
		actual[5]=tr.addNode(s_Name1,s_Desc1);
		
		String[] system=new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 6, 2);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 6, 5);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		bp.waitForElement();
		tr.navigateToNode(releaseName, system);
		bp.waitForElement();
		bp.waitForElement();
		actual[6]=tr.addNode(ss_Name1,ss_Desc1);
		
		String[] subsystem=new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		actual[7]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[8]=tr.navigateToNode(releaseName, subsystem);
		bp.waitForElement();
		
		for(int i=1;i<=50;i++)
		{
			actual[9]=tr.addTestCase();
		}
		
		
		}
	    catch(Exception e)
	    {
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    driver.close();
	     Relogin rl=new Relogin();
	     rl.reLogin();
	     throw e;
	    }
	}

	@When("^User Sets the per page size to ten and navigate between pages$")
	public void user_Sets_the_per_page_size_to_ten_and_navigate_between_pages() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 5));
			actual[10]=tr.selectTestCasesPerPage(pageNumber);
			bp.waitForElement();
			
			actual[11]=tr.clickOnNextAndPrev();
			bp.waitForElement();
			/*np=new NavigationPage(driver);
			//bp.waitForElement();
			//bp.waitForElement();
			//bp.waitForElement();
			//WebDriverWait wait2=new WebDriverWait(driver, 100);
			//wait2.until(ExpectedConditions.elementToBeClickable());
			actual[12]=tr.navigatingPageNumbers();
			bp.waitForElement();*/
	    }
	    catch(Exception e)
	    {
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    driver.close();
	     Relogin rl=new Relogin();
	     rl.reLogin();
	     throw e;
	    }
	}

	@Then("^Navigation between pages is done successfully$")
	public void navigation_between_pages_is_done_successfully() throws Throwable {
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
		     {
	    		System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();

		log.info("Navigation between pages is done Successfully");
	    }
	    catch(Exception e)
	    {
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
	    driver.close();
	     Relogin rl=new Relogin();
	     rl.reLogin();
	     throw e;
	    }
	}

	
}
