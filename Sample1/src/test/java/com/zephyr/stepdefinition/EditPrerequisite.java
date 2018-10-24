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

public class EditPrerequisite extends LaunchBrowser
{

	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Editprerequisite";
	
	boolean[] actual=new boolean[20];
	 SoftAssert soft=new SoftAssert();

	 
	@Given("^User selects the Project and Select release$")
	public void user_selects_the_Project_and_Select_release() throws Throwable {
	try
	{
		bp=new BasePage();
		pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);
		actual[0]=pp.selectProject(projectName);
		actual[1]=pp.selectRelease(releaseName);
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
	  	Relogin rl=new Relogin();
	  	rl.reLogin();
	  	throw e;
		 
	}
	}
	

	@When("^user naviagate to Test Repository page$")
	public void user_naviagate_to_Test_Repository_page() throws Throwable {
		 try
		 {
			 rp=new ReleasePage(driver);
		 
			 actual[2]= rp.clickOnTestRep();
		 }
		 catch(Exception e)
			{  lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
			  	Relogin rl=new Relogin();
			  	rl.reLogin();
			  	throw e;
				 
			}
			
	}

	@When("^double click On Release$")
	public void double_click_On_Release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
	    //bp.waitForElement();
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
	}

	@When("^create a Phase and navigate to Phase and add test cases$")
	public void create_a_Phase_and_navigate_to_Phase_and_add_test_cases() throws Throwable {
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);
		String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		

		actual[6]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		for(int i=1;i<=5;i++)
		{
			actual[7]=tr.addTestCase();
		}
		bp.waitForElement();
		}
		catch(Exception e)
		{  lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
	}

	@When("^Read the test case Count$")
	public void read_the_test_case_Count() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);
		actual[8]=tr.verifyPresentTestCase();
		actual[9]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
	}

	@When("^create a System  and navigate to system and add test cases$")
	public void create_a_System_and_navigate_to_system_and_add_test_cases() throws Throwable {
		try
		{
		String[] node2=new String[1];
		 node2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		//node2[1]=Excel_Lib.getData(INPUT_PATH, "CreatePrerequisite", 1, 3);
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);;
		actual[10]=tr.navigateToNode(releaseName, node2);
		
		String phasename2=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 3);
		String desc2=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 3);
		actual[11]=tr.addNode(phasename2, desc2);
		
		
		
		bp.waitForElement();
		bp.waitForElement();
		actual[12]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] node3=new String[2];
		 node3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		node3[1]=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 3);
		
		actual[13]=tr.navigateToNode(releaseName, node3);
		
		
		for(int i=1;i<=5;i++)
		{
			actual[14]=tr.addTestCase();
		}
		bp.waitForElement();
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
	}

	@When("^create Subsystem and navigate to subsystem and add test cases$")
	public void create_Subsystem_and_navigate_to_subsystem_and_add_test_cases() throws Throwable {
		try
		{
		String[] node4=new String[2];
		 node4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		node4[1]=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 3);
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 1);;
		actual[15]=tr.navigateToNode(releaseName, node4);
		
		String phasename3=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 4);
		String desc3=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 4);
		actual[16]=tr.addNode(phasename3, desc3);
		
		
		
		bp.waitForElement();
		bp.waitForElement();
		actual[17]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] node5=new String[3];
		 node5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 2);
		node5[1]=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 3);
		node5[2]=Excel_Lib.getData(INPUT_PATH_2, "EditPrerequisite", 1, 4);
		actual[18]=tr.navigateToNode(releaseName, node5);
		
		
		for(int i=1;i<=5;i++)
		{
			actual[19]=tr.addTestCase();
		}
		bp.waitForElement();
		}
		catch(Exception e)
		{   lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
		  	Relogin rl=new Relogin();
		  	rl.reLogin();
		  	throw e;
			 
		}
	}
}
