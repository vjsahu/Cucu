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

public class DNDPrerequisite extends LaunchBrowser {

	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="DNDPrerequisite";
	
boolean[] actual=new boolean[18];
	
	SoftAssert soft=new SoftAssert();
	
@Given("^User select the projects (\\d+)$")
public void user_select_the_projects(int arg1) throws Throwable {
	try
	{
	bp=new BasePage();
	pp=new ProjectPage(driver);
	if(arg1==1 || arg1==2 ||arg1==8)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	}
	
	if(arg1==3)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_2");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	}
	if(arg1==4)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	}
	if(arg1==5)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_2");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	}
	if(arg1==6)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Isolated_Project_1");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	}
//	if(arg1==7)
//	{
//	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Project6");
//	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
//	actual[0]=pp.selectProject(projectName);
//	}
	if(arg1==7)
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
	
	}
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

@When("^User click on Release (\\d+)$")
public void user_click_on_Release(int arg1) throws Throwable {
	try
	{
	if(arg1==2 || arg1==3 || arg1==4||arg1==5||arg1==6||arg1==7 || arg1==8)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	actual[1]=pp.selectRelease(releaseName);
	}
	else
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	actual[1]=pp.selectRelease(releaseName);
	}
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

@When("^Navigated to test Repository Page$")
public void navigated_to_test_Repository_Page() throws Throwable {
	try
	{
	rp=new ReleasePage(driver);
	actual[2]=rp.clickOnTestRep();
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

@When("^Double Click On release(\\d+)$")
public void double_Click_On_release(int arg1) throws Throwable {
	
	try
	{
	tr=new TestRepositoryPage(driver);
	if(arg1==2 || arg1==3 || arg1==4||arg1==5||arg1==6||arg1==7||arg1==8)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	actual[3]=tr.clickOnRelease(releaseName);
	}
	else
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	actual[3]=tr.clickOnRelease(releaseName);
	}
	
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

@When("^Creates a phase (\\d+) and Add test Cases to the Phase$")
public void creates_a_phase_and_Add_test_Cases_to_the_Phase(int arg1) throws Throwable {
   try
   {
	if(arg1==1)
   {
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
		actual[4]=tr.addNode(phasename, desc);
		
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
		
		
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   
   if(arg1==2)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
		
		
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   if(arg1==3)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
		
		
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   if(arg1==4)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
		
		
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   if(arg1==5)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
		
		;
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   if(arg1==6)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
		
		//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
//   if(arg1==7)
//   {
//	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
//	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2,2 );
//		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//		actual[4]=tr.addNode(phasename, desc);
//		bp.waitForElement();
//		bp.waitForElement();
//		
//		tr.doubleClickOnRelease(releaseName);
//		bp.waitForElement();
//		String[] node1=new String[1];
//		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//		
//		//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
//		
//		actual[5]=tr.navigateToNode(releaseName, node1);
//		bp.waitForElement();
//		
//		for(int i=1;i<=5;i++)
//		{
//			actual[6]=tr.addTestCase();
//		}
//		bp.waitForElement();
//		
//   }
   
   if(arg1==7)
   {
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8,2 );
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
		actual[4]=tr.addNode(phasename, desc);
		bp.waitForElement();
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
		
		//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
   
   
   if(arg1==8)
   {
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	   String phasename=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
		actual[4]=tr.addNode(phasename, desc);
		
		bp.waitForElement();
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String[] node1=new String[1];
		node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
		
		
		
		actual[5]=tr.navigateToNode(releaseName, node1);
		bp.waitForElement();
		
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		
   }
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





@Then("^Test cases Added to the Phase$")
public void test_cases_Added_to_the_Phase() throws Throwable {
	try
	{
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	tr.verifyPresentTestCase();
//	tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
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

@When("^Creates a System (\\d+) and Add test Cases to the System$")
public void creates_a_System_and_Add_test_Cases_to_the_System(int arg1) throws Throwable {
	try
	{
	if(arg1==1)
	 {
		
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 3);
	actual[8]=tr.addNode(phasename, desc);
	bp.waitForElement();
	bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[2];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 3);
	actual[10]=tr.navigateToNode(releaseName, node11);
	
	bp.waitForElement();
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 if(arg1==2)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node12=new String[2];
	node12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
	node12[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 3);
	actual[10]=tr.navigateToNode(releaseName, node12);
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 if(arg1==3)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node13=new String[2];
	node13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
	node13[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 3);
	actual[10]=tr.navigateToNode(releaseName, node13);
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 if(arg1==4)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	
	bp.waitForElement();
	bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node14=new String[2];
	node14[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
	node14[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 3);
	actual[10]=tr.navigateToNode(releaseName, node14);
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 if(arg1==5)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node15=new String[2];
	node15[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
	node15[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 3);
	actual[10]=tr.navigateToNode(releaseName, node15);
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 if(arg1==6)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node16=new String[2];
	node16[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
	node16[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 3);
	actual[10]=tr.navigateToNode(releaseName, node16);
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
//	 if(arg1==7)
//	 {
//	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
//	//tr.doubleClickOnRelease(releaseName)
//	tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
//	
//	String[] node1=new String[1];
//	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//	
//	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
//	
//	actual[7]=tr.navigateToNode(releaseName, node1);
//	
//	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
//	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
//	actual[8]=tr.addNode(phasename, desc);
//	
//	bp.waitForElement();
//	bp.waitForElement();
//	//bp.waitForElement();
//	
//	actual[9]=tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
//	
//	String[] node17=new String[2];
//	node17[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//	node17[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
//	actual[10]=tr.navigateToNode(releaseName, node17);
//	
//	for(int i=1;i<=5;i++)
//	{
//		actual[11]=tr.addTestCase();
//	}
//	bp.waitForElement();
//	 }
	 
	 
	 if(arg1==7)
	 {
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 3);
	actual[8]=tr.addNode(phasename, desc);
	
	bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node18=new String[2];
	node18[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
	node18[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 3);
	actual[10]=tr.navigateToNode(releaseName, node18);
	
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
	 
	 
	 
	 if(arg1==8)
	 {
		
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	//tr.doubleClickOnRelease(releaseName)
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	
	String[] node1=new String[1];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[7]=tr.navigateToNode(releaseName, node1);
	
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 3);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 3);
	actual[8]=tr.addNode(phasename, desc);
	bp.waitForElement();
	bp.waitForElement();
	
	actual[9]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[2];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 3);
	actual[10]=tr.navigateToNode(releaseName, node11);
	
	bp.waitForElement();
	
	for(int i=1;i<=5;i++)
	{
		actual[11]=tr.addTestCase();
	}
	bp.waitForElement();
	 }
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
	


@Then("^Test cases Added to the System$")
public void test_cases_Added_to_the_System() throws Throwable {
	try
	{
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	tr.verifyPresentTestCase();
	//tr.doubleClickOnRelease(releaseName);
	//bp.waitForElement();
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

@When("^Creates a subsystem (\\d+) and Add test cases to the subsystem$")
public void creates_a_subsystem_and_Add_test_cases_to_the_subsystem(int arg1) throws Throwable {
	try
	{
	
	if(arg1==1)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
	
   bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[3];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 3);
	node11[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 4);
	actual[15]=tr.navigateToNode(releaseName, node11);
	
   
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
	
	
	
	if(arg1==2)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
	
   bp.waitForElement();
   
   actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node12=new String[3];
	node12[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 2);
	node12[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 3);
	node12[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 4);
	actual[15]=tr.navigateToNode(releaseName, node12);
	
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
	if(arg1==3)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 4);
	actual[13]=tr.addNode(phasename, desc);
	
	
	 bp.waitForElement();
	 
   bp.waitForElement();
   
   actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node13=new String[3];
	node13[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 2);
	node13[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 3);
	node13[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 3, 4);
	actual[15]=tr.navigateToNode(releaseName, node13);
	
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
	if(arg1==4)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
   bp.waitForElement();
   
   actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node14=new String[3];
	node14[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 2);
	node14[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 3);
	node14[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 4, 4);
	actual[15]=tr.navigateToNode(releaseName, node14);
	
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
	if(arg1==5)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
	
   
   bp.waitForElement();
   actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node15=new String[3];
	node15[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 2);
	node15[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 3);
	node15[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 5, 4);
	actual[15]=tr.navigateToNode(releaseName, node15);
	
   
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
	if(arg1==6)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
   bp.waitForElement();
   actual[14]= tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node16=new String[3];
	node16[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 2);
	node16[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 3);
	node16[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 7, 4);
	actual[15]=tr.navigateToNode(releaseName, node16);
	
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	
//	if(arg1==7)
//	{
//	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
//	
//	tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
//	
//	String[] node1=new String[2];
//	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
//	
//	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
//	
//	actual[12]=tr.navigateToNode(releaseName, node1);
//	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
//	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
//	actual[13]=tr.addNode(phasename, desc);
//	
//   bp.waitForElement();
//   bp.waitForElement();
//   actual[14]=tr.doubleClickOnRelease(releaseName);
//	bp.waitForElement();
//	bp.waitForElement();
//	
//	String[] node17=new String[3];
//	node17[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 2);
//	node17[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 3);
//	node17[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 6, 4);
//	actual[15]=tr.navigateToNode(releaseName, node17);
//	
//	for(int i=1;i<=5;i++)
//	{
//		actual[16]=tr.addTestCase();
//	}
//	bp.waitForElement();
//	}
//					 

	if(arg1==7)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
   bp.waitForElement();
   actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	bp.waitForElement();
	
	String[] node17=new String[3];
	node17[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 2);
	node17[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 3);
	node17[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 8, 4);
	actual[15]=tr.navigateToNode(releaseName, node17);
	
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	
	}
	
	if(arg1==8)
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 1, 1);
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node1=new String[2];
	node1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
	node1[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 3);
	
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	
	actual[12]=tr.navigateToNode(releaseName, node1);
	String phasename=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 4);
	String desc=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 4);
	actual[13]=tr.addNode(phasename, desc);
	
   bp.waitForElement();
	
   bp.waitForElement();
	bp.waitForElement();
	//bp.waitForElement();
	
	actual[14]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	String[] node11=new String[3];
	node11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 2);
	node11[1]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 3);
	node11[2]=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 9, 4);
	actual[15]=tr.navigateToNode(releaseName, node11);
	
   
	for(int i=1;i<=5;i++)
	{
		actual[16]=tr.addTestCase();
	}
	bp.waitForElement();
	}
	
	}


    catch(Exception e)
			{lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
			  	Relogin rl=new Relogin();
			  	rl.reLogin();
			  	throw e;
				 
			}
}


@Then("^Test cases Added to the Subsystem$")
public void test_cases_Added_to_the_Subsystem() throws Throwable {
	try
	{
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "DNDPrerequisite", 2, 1);
	actual[17]=tr.verifyPresentTestCase();
	for(int k=0;k<=actual.length-1;k++)
	   {
	   	System.out.println(actual[k]);
	   	soft.assertEquals(actual[k], true);
	   }
		
		soft.assertAll();
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


