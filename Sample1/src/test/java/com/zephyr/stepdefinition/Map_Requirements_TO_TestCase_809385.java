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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_Requirements_TO_TestCase_809385 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_Requirements_TO_TestCase_809385";
	
	boolean[] actual=new boolean[13];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page Requirements$")
	public void user_is_in_a_page_Requirements() throws Throwable {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		  // WebDriver driver = null;
		 lp=new LoginPage(driver);
		   
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		try
		{
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   bp.waitForElement();
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		  bp.waitForElement();
		  bp.waitForElement();
		   actual[2]=rp.clickOnRequirements();
		   bp.waitForElement();
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

	@Given("^User creates an node under release$")
	public void user_creates_an_node_under_release() throws Throwable {
		try
	    {
		String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 7, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 7, 3);
		
		req=new RequirementsPage(driver);
		
		bp=new BasePage();
		bp.waitForElement();
		actual[3]=req.doubleClickOnRelease(releaseName1);
		//bp=new BasePage();
		bp.waitForElement();
		actual[4]=req.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
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

	@When("^User creates two to three requirements under a node$")
	public void user_creates_two_to_three_requirements_under_a_node() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 7, 0);
		//String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		tr=new TestRepositoryPage(driver);

		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		//bp.waitForElement();
		actual[6]=tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
		//RequirementsPage_POM req=new RequirementsPage(driver);
		req.addRequirement();
		req.addRequirement();
		req.addRequirement();
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

	@When("^User is in a page of testRepository$")
	public void user_is_in_a_page_of_testRepository() throws Throwable {
		try
	    {
			bp.waitForElement();
			bp.waitForElement();
		actual[7]=rp.clickOnTestRep();
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

	@When("^User creates an phase under a release$")
	public void user_creates_an_phase_under_a_release() throws Throwable {
		try
	    {
			tr=new TestRepositoryPage(driver);
			
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 8, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 8, 3);
		actual[8]=tr.doubleClickOnRelease(releaseName);
		actual[9]=tr.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
		//actual[12]=tr.addTestCase();
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

	@Then("^User creates two to three testcases$")
	public void user_creates_two_to_three_testcases() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 8, 0);
			//String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 8, 3);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			bp.waitForElement();
			for(int i=0;i<=2;i++)
			{
				bp.waitForElement();
				actual[10]=tr.addTestCase();
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

	@Then("^User go to a testcase details$")
	public void user_go_to_a_testcase_details() throws Throwable {
		try
	    {
		//tr.clickOnDetailView.click();
		tr.clickDetailButton();
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

	@When("^User maps requirements$")
	public void user_maps_requirements() throws Throwable {
		try
	    {
			req=new RequirementsPage(driver);
			bp.waitForElement();
			bp.waitForElement();
	    	actual[11]=req.MapRequirements();
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

	@Then("^User seelects a release node$")
	public void user_seelects_a_release_node() throws Throwable {
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		tr.clickOnReleaseCheckBox.click();
		//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		//actual[17]=req.ExpandRelease(releaseName);
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

	@Then("^User clicks on a save$")
	public void user_clicks_on_a_save() throws Throwable {
		 try
		    {
			bp.waitForElement();
			actual[12]=req.saveRequirement();
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
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

	@Then("^Mapping of requirements to testcase by selectsing a release node is done successfully$")
	public void mapping_of_requirements_to_testcase_by_selectsing_a_release_node_is_done_successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
	     {
				System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("Map Requirements to testcase by selecting release node is done successfully");
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
