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

public class Map_TestCase_to_Requirement_809379 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_TestCase_to_Requirement_809379";
	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page of a Requirements$")
	public void user_is_in_a_page_of_a_Requirements() throws Throwable {
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

	@Given("^User creates a node an release$")
	public void user_creates_a_node_an_release() throws Throwable {
		try
	    {
			req=new RequirementsPage(driver);
			
		String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 5, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 5, 3);
	
		bp.waitForElement();
		actual[3]=req.doubleClickOnRelease(releaseName1);
		bp.waitForElement();
		actual[4]=req.addNode(p_Name1,p_Desc1);
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

	@When("^User creates two to three requirements under an node$")
	public void user_creates_two_to_three_requirements_under_an_node() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 5, 0);
		//String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 7, 0);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		actual[5]=req.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr=new TestRepositoryPage(driver);
		bp.waitForElement();
		//tr.doubleClickOnRelease(releaseName);
		//bp.waitForElement();
		actual[6]=tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
		//req=new RequirementsPage(driver);
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

	@When("^User is in a testRepository$")
	public void user_is_in_a_testRepository() throws Throwable {
		try
	    {
			bp.waitForElement();
			bp.waitForElement();
		rp.clickOnTestRep();
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

	@When("^User creates an phase under release$")
	public void user_creates_an_phase_under_release() throws Throwable {
		try
	    {
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 9, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map", 10, 0);
		actual[7]=tr.doubleClickOnRelease(releaseName);
		actual[8]=tr.addNode(p_Name1,p_Desc1);
//		bp.waitForElement();
//		bp.waitForElement();
		//String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map", 2, 0);
		String[] phase=new String[1];
		phase[0]=p_Name1;
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    tr.navigateToNode(releaseName, phase);
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

	@Then("^User creates an two to three testcases$")
	public void user_creates_an_two_to_three_testcases() throws Throwable {
		for(int i=0;i<=2;i++)
		{
			try
			{	bp.waitForElement();
				actual[9]=tr.addTestCase();
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

	@Then("^User selects an testcase$")
	public void user_selects_an_testcase() throws Throwable {
		try
	    {
			bp.waitForElement();
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

	@When("^User maps the requirements$")
	public void user_maps_the_requirements() throws Throwable {
		 try
		    {
			 bp.waitForElement();
			 bp.waitForElement();
		    	actual[10]=req.MapRequirements();
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

	@Then("^User selects an entire node and expands and view it in an grid$")
	public void user_selects_an_entire_node_and_expands_and_view_it_in_an_grid() throws Throwable {
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		tr.clickOnReleaseCheckBox.click();
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		actual[11]=req.ExpandRelease(releaseName);
		bp.waitForElement();
		actual[12]=req.saveRequirement();
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

	@Then("^User unchecks the entire release node and view in a grid$")
	public void user_unchecks_the_entire_release_node_and_view_in_a_grid() throws Throwable {
		try
		{
			req=new RequirementsPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		actual[13]=req.MapRequirements();
		bp.waitForElement();
		tr.clickOnReleaseCheckBox.click();
		/*String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		bp.waitForElement();
		actual[14]=req.ExpandRelease(releaseName);
		bp.waitForElement();
		tr.clickOnReleaseCheckBox.click();
		bp.waitForElement();
		actual[15]=req.saveRequirement();*/
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

	@Then("^User similarly selects the node should selects the headder checkbox as well$")
	public void user_similarly_selects_the_node_should_selects_the_headder_checkbox_as_well() throws Throwable {
		try
	    {
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			actual[14]=req.ExpandRelease(releaseName);
			bp.waitForElement();
			tr.clickOnReleaseCheckBox.click();
			bp.waitForElement();
			bp.waitForElement();
			actual[15]=req.saveRequirement();
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
		for(int k=0;k<=actual.length-1;k++)
	     {
			System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("selecting the node should select the headder checkbox as well successfully");
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
