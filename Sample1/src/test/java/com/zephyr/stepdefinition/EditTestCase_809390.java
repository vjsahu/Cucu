package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_809390 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	NavigationPage np;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTestCase_809390";
	boolean[] actual=new boolean[12];
	   SoftAssert soft=new SoftAssert();
	   
@Given("^User is in the test repsository page$")
public void user_is_in_the_test_repsository_page() throws Throwable {
	try
	{
//	   lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
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

@When("^User selects and copy the node$")
public void user_selects_and_copy_the_node() throws Throwable {
	try
	{
		bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	
	tr=new TestRepositoryPage(driver);
	actual[3]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	String node1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 15, 0);
	String desc1=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 15, 0);
	actual[4]=tr.addNode(node1, desc1);
	bp.waitForElement();
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	
	
	
	
	
	
	String[] node=new String[1];
	 node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 15, 0);
	 //tr=new TestRepositoryPage(driver);
	 actual[3]=tr.navigateToNode(releaseName, node);
	 actual[5]=tr.copyNode();
	 actual[6]=tr.doubleClickOnRelease(releaseName);
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

@When("^select the node and paste the copied node$")
public void select_the_node_and_paste_the_copied_node() throws Throwable 
{
	try
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
		
		
		actual[7]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		String node2=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 16, 0);
		String desc2=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 16, 0);
		actual[8]=tr.addNode(node2, desc2);
		bp.waitForElement();
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		
   //String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
   String[] node=new String[1];
   node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 16, 0);
   actual[6]=tr.navigateToNode(releaseName, node);
      actual[9]=tr.pasteNode();
      bp.waitForElement();
      tr.doubleClickOnRelease(releaseName);
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

@Then("^selected node should be copied to other node$")
public void selected_node_should_be_copied_to_other_node() throws Throwable {
   
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	String[] node=new String[2];
	node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 16, 0);
	System.out.println(node[0]);
	node[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 15, 0);
	System.out.println(node[1]);
	actual[10]=tr.navigateToNode(releaseName, node);
	np=new NavigationPage(driver);
	String[] breadCrumbs=new String[3];
	breadCrumbs[0]=Excel_Lib.getData(INPUT_PATH_2,"Common",2,1);
	breadCrumbs[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 15, 0);
	breadCrumbs[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 16, 0);
	
	actual[11]=np.checkingBreadCrumbs(node);
	
	
	for(int k=0;k<=actual.length-1;k++)
    {
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
