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

public class ExportPrecondition1 extends LaunchBrowser {
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;

	LaunchBrowser lb=new LaunchBrowser();
	
	boolean[] actual=new boolean[31];
	 SoftAssert soft=new SoftAssert();
	 
	 String fileName="ExportPrecondition1";
@Given("^User Selects the Project$")
public void user_Selects_the_Project() throws Throwable {
	try
	{
	bp=new BasePage();
	pp=new ProjectPage(driver);
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	//String releaseName=Excel_Lib.getData(INPUT_PATH_2_2, "ExportPrerequisite", 1, 1);
	actual[0]=pp.selectProject(projectName);
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
	//pp.selectRelease(releaseName);
}

@When("^User Selects the Relaese$")
public void user_Selects_the_Relaese() throws Throwable {
try
{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	actual[1]=pp.selectRelease(releaseName);
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

@When("^Navigate to Test Repository Page Module$")
public void navigate_to_Test_Repository_Page_Module() throws Throwable {
	
	try
	{
		rp=new ReleasePage(driver);
	
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



@When("^Double Click On the Release$")
public void double_Click_On_the_Release() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
	tr=new TestRepositoryPage(driver);
	actual[3]=tr.clickOnRelease(releaseName);
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

@When("^Creates a Phases <Count> upto Eighth Level$")
public void creates_a_Phases_Count_upto_Eighth_Level() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",1,1);
	String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
	String Desc1=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
	actual[4]=tr.addNode(Name1, Desc1);
	bp.waitForElement();
	bp.waitForElement();
	actual[5]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
    String Name2=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
	String Desc2=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    String add1[]=new String[1];
    add1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    actual[6]= tr.navigateToNode(releaseName, add1);
    bp.waitForElement();
    actual[7]=tr.addNode(Name2, Desc2);
    bp.waitForElement();
    bp.waitForElement();
    actual[8]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name3=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
	String Desc3=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
    String add2[]=new String[2];
    add2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add2[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    actual[9]=tr.navigateToNode(releaseName, add2);
    bp.waitForElement();
    actual[10]=tr.addNode(Name3, Desc3);
    bp.waitForElement();
    bp.waitForElement();
    actual[11]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name4=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
	String Desc4=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
    String add3[]=new String[3];
    add3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add3[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    add3[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);;
    actual[12]=tr.navigateToNode(releaseName, add3);
    bp.waitForElement();
    actual[13]=tr.addNode(Name4, Desc4);
    bp.waitForElement();
    bp.waitForElement();
    actual[14]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name5=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 6);
	String Desc5=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 6);
    String add4[]=new String[4];
    add4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add4[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    add4[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
    add4[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
    actual[15]=tr.navigateToNode(releaseName, add4);
    bp.waitForElement();
    actual[16]=tr.addNode(Name5, Desc5);
    bp.waitForElement();
    bp.waitForElement();
    actual[17]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name6=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 7);
	String Desc6=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 7);
    String add5[]=new String[5];
    add5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add5[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    add5[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
    add5[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
    add5[4]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 6);
    actual[18]=tr.navigateToNode(releaseName, add5);
    bp.waitForElement();
    actual[19]=tr.addNode(Name6, Desc6);
    bp.waitForElement();
    bp.waitForElement();
    actual[20]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name7=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 8);
	String Desc7=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 8);
    String add6[]=new String[6];
    add6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add6[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    add6[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
    add6[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
    add6[4]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 6);
    add6[5]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 7);
    actual[21]=tr.navigateToNode(releaseName, add6);
    bp.waitForElement();
    actual[22]=tr.addNode(Name7, Desc7);
    bp.waitForElement();
    bp.waitForElement();
    actual[23]=tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
    String Name8=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 9);
	String Desc8=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 9);
    String add7[]=new String[7];
    add7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
    add7[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 3);
    add7[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 4);
    add7[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 5);
    add7[4]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 6);
    add7[5]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 7);
    add7[6]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 8);
    actual[24]=tr.navigateToNode(releaseName, add7);
    bp.waitForElement();
    actual[25]=tr.addNode(Name8, Desc8);
    bp.waitForElement();
    actual[26]=tr.doubleClickOnRelease(releaseName);
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



@When("^Add Test Cases to Eighth Level test Cases$")
public void add_Test_Cases_to_Eighth_Level_test_Cases() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",1,1);
	String[] node=new String[8];
	node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 2);
	int k=1;
	for(int i=3;i<=9;i++)
	{
		node[k]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, i);
	k++;
	}
	actual[27]=tr.navigateToNode(releaseName, node);
	bp.waitForElement();
	for(int i=1;i<=5;i++)
	{
		actual[28]=tr.addTestCase();
	}
	bp.waitForElement();
	
	actual[29]=tr.clickDetailButton();
	bp.waitForElement();
	ctc=new CreateTestCasePage(driver);
	String stepDetails[]=new String[9];
	stepDetails[0]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 10);
	stepDetails[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 11);
	stepDetails[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 12);
	
	
	stepDetails[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 10);
	stepDetails[4]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 11);
	stepDetails[5]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 12);
	
	
	stepDetails[6]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 10);
	stepDetails[7]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 11);
	stepDetails[8]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 12);
	
	actual[30]=ctc.enterTestCaseStepDetail(stepDetails);
	bp.waitForElement();
	tr.clickOnList();
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
	
	//ctc.enterTestCaseStepDetail(stepDetails)
}

@Then("^Test Case Added To the Node$")
public void test_Case_Added_To_the_Node() throws Throwable {
  try
  {
	tr.verifyPresentTestCase();
    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",1,1);
    tr.doubleClickOnRelease(releaseName);
    bp.waitForElement();
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
