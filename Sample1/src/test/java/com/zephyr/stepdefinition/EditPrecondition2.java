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
import cucumber.api.java.en.When;

public class EditPrecondition2 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditPrecondition2";
	
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User Selects the Project and selects release$")
	public void user_Selects_the_Project_and_selects_release() throws Throwable {
	try
	{
		bp=new BasePage();
		pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 4, 1);
		actual[0]=pp.selectProject(projectName);
		actual[1]=pp.selectRelease(releaseName);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin rl=new Relogin();
		rl.reLogin();
		throw e;
	}
	}

	@When("^User Naviagate to Test Repository page$")
	public void user_Naviagate_to_Test_Repository_page() throws Throwable {
		
		try
		{
			rp=new ReleasePage(driver);
		actual[2]= rp.clickOnTestRep();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Double Click On Release$")
	public void double_Click_On_Release() throws Throwable {
		
		try
		{String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 4, 1);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	
	
	
@When("^Creates a Phase and navigate to Phase and add test cases$")
public void creates_a_Phase_and_navigate_to_Phase_and_add_test_cases() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 4, 1);
	
	String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
	actual[4]=tr.addNode(phasename, desc);
	bp.waitForElement();
	bp.waitForElement();
	
	actual[5]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	bp.waitForElement();
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
	
	actual[6]=tr.navigateToNode(releaseName, node1);
	bp.waitForElement();
	for(int i=1;i<=5;i++)
	{
		actual[7]=tr.addTestCase();
	}
	bp.waitForElement();}
	catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.close();
		Relogin rl=new Relogin();
		rl.reLogin();
		throw e;
	}
}


	

	@When("^Read the Test Case Count$")
	public void read_the_Test_Case_Count() throws Throwable {
		
		try
		{String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 4, 1);
		actual[8]=tr.verifyPresentTestCase();
		actual[9]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    bp.waitForElement();}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
}
